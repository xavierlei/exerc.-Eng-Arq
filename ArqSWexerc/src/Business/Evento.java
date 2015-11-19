/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 *
 * @author xavier
 */
public class Evento extends Subject {
    private Integer key;
    private Odd oddAtual;
    private String eq1;
    private String eq2;
    private int resultado[];
    private boolean aberto;
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
    private HashMap<Apostador,ArrayList<Aposta>> listaApostas;
    private Bookie dono;
    

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int year = inicio.get(Calendar.YEAR);
        int month = inicio.get(Calendar.MONTH)+1;
        int day = inicio.get(Calendar.DAY_OF_MONTH);
        int fyear = fim.get(Calendar.YEAR);
        int fmonth = fim.get(Calendar.MONTH)+1;
        int fday = fim.get(Calendar.DAY_OF_MONTH);
        sb.append("id: "+this.key+"\n");
        sb.append("dono: "+this.dono.getUsrName()+"\n");
        sb.append(this.eq1+":"+this.resultado[0] +" vs " + this.eq2+":"+this.resultado[1] +"\n");
        sb.append(this.oddAtual.toString()+"\n");
        sb.append("estado: "+this.aberto+"\n");
        sb.append("inicio: "+year+"/"+month+"/"+day+"\n");
        sb.append("fim: "+fyear+"/"+fmonth+"/"+fday+"\n");
        return sb.toString();
    }
    
    public Evento(Odd odd, String eq1, String eq2, 
            GregorianCalendar inicio, GregorianCalendar fim, Integer key, Bookie b) {
        
        
        this.oddAtual = odd;
        this.eq1 = eq1;
        this.eq2 = eq2;
        this.aberto = true;
        this.inicio = inicio;
        this.fim = fim;
        this.key = key;
        this.resultado = new int[3];
        this.listaApostas = new HashMap<Apostador,ArrayList<Aposta>>();
        this.dono = b;
        this.addObserver("interessados",b);
        this.addObserver("todos", b);
    }
    
   
    //Gets
    public Integer getKey(){
        return this.key;
    }
    public Odd getOdd() {
        return this.oddAtual;
    }

    public String getEq1() {
        return this.eq1;
    }

    public String getEq2() {
        return this.eq2;
    }
    public HashMap<Apostador,ArrayList<Aposta>> getApostas(){
        return this.listaApostas;
    }
    public Bookie getBookie(){return this.dono;}
   
    //Sets
    public void setOdd(Odd odd){
        //for(Float o: odd) this.odd.add(o);
        this.oddAtual = odd;
        String msg = "a odd do evento: "+this.getKey()+" foi alterada para "+odd.getOddEquipaCasa()+":"
                     +odd.getOddEmpate()+":"+odd.getOddEquipaFora();
        Notificacao n = new Notificacao(this.key, msg);
        
        this.setChanged("todos");
        this.notifyObservers("todos",n);
    }
    public void setEquipa1(String eq1) {
        this.eq1 = eq1;
    }

    public void setEquipa2(String eq2) {
        this.eq2 = eq2;
    }

    public void setInicio(GregorianCalendar inicio) {
        this.inicio = inicio;
    }

    public void setFim(GregorianCalendar fim) {
        this.fim = fim;
    }
    
    
    public void addInteressado(Bookie b){
        this.addObserver("interessados",b);
        this.addObserver("todos", b);
    }
    
    //Registar Evento 
    public Aposta apostarAqui( Apostador apostador, Aposta novaAposta ){
        if(!this.isOpen()) return null;
        if( novaAposta.getNomeDaEquipa().equals(this.eq1) || novaAposta.getNomeDaEquipa().equals(this.eq2) 
                || novaAposta.getNomeDaEquipa().equals("empate")){
            novaAposta.setOddMomento( this.oddAtual );
            if(listaApostas.containsKey(apostador)){
                listaApostas.get(apostador).add(novaAposta);
            }
            else{
                ArrayList<Aposta> ap = new ArrayList<Aposta>();
                ap.add(novaAposta);
                listaApostas.put(apostador, ap);
                addObserver("apostadores", apostador);
                addObserver("todos", apostador);
            }
            
            return novaAposta;
        }
            return null;
        
    }
    
    //verificar se é possivel apostar 
    public boolean isOpen(){
        return this.aberto;
    }
    
    
    
    private double atribuiPremios(HashMap<Apostador,ArrayList<Aposta>> listaApostas, int[]result){
        double totalGanho = 0;
        for(Apostador kApostador : this.listaApostas.keySet()){
            double totBc=0;
            for(Aposta ap : listaApostas.get(kApostador)){
                // As Três formas de Ganhar! uma Aposta
                if(result[0] > result[1] && ap.getNomeDaEquipa().equals(eq1)){
                    double bc = ap.getValorApostado() * ap.getOdd().getOddEquipaCasa();
                    ap.setResult(true);
                    totBc+=bc;
                }
                else if(result[1]>result[0] && ap.getNomeDaEquipa().equals(eq2)){
                    double bc = ap.getValorApostado() * ap.getOdd().getOddEquipaFora();
                    ap.setResult(true);
                    totBc+=bc;
                }
                else if(result[0] == result[1] && ap.getNomeDaEquipa().equals("empate") ){
                    double bc = ap.getValorApostado() * ap.getOdd().getOddEmpate();
                    ap.setResult(true);
                    totBc+=bc;
                }else{
                    ap.setResult(false);   
                }
                ap.setResult_is_set(true);        
            }
            kApostador.adicionarBetcoins( totBc );
            String msg = "ganhou "+totBc+" coins no evento "+ this.key;
            Notificacao n = new Notificacao(key, msg);
            this.setChanged("apostadores");
            notifyObserver("apostadores", kApostador, n);
            totalGanho +=totBc;
        }
        return totalGanho;
    }
    
    public void terminarEvento(int result[]){
        this.aberto = false;
        this.resultado = result;
        double totalGanho = 0;
        totalGanho = this.atribuiPremios(this.listaApostas, result);
        String msg = "o evento terminou com o resultado :: "+this.eq1+":"+this.resultado[0]
                     +" vs "+this.eq2+":"+this.resultado[1];
        Notificacao n = new Notificacao(this.key, msg);
        this.setChanged("todos");
        this.notifyObservers("todos",n);   
        String msg2 ="valor total ganho no evento "+this.key+" = "+totalGanho+" coins";
        Notificacao n2 = new Notificacao(this.key, msg2);
        this.setChanged("interessados");
        this.notifyObserver("interessados",this.dono ,n2);
        this.deleteObservers("todos");
        this.deleteObservers("apostadores");
        this.deleteObservers("interessados");
    }
        
}
