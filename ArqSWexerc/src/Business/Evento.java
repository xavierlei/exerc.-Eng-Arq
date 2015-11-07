/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

/**
 *
 * @author xavier
 */
public class Evento extends Observable {
    private Integer key;
    private ArrayList<Float> odd;
    private String eq1;
    private String eq2;
    private int resultado[];
    private boolean aberto;
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
    private HashMap<Apostador,ArrayList<Aposta>> listaApostas;
    

    
    
    public Evento(ArrayList<Float> odd, String eq1, String eq2, 
            GregorianCalendar inicio, GregorianCalendar fim, Integer key) {
        
        this.odd = new ArrayList<Float>();
            for(Float o: odd) this.odd.add(o);
        this.eq1 = eq1;
        this.eq2 = eq2;
        this.aberto = true;
        this.inicio = inicio;
        this.fim = fim;
        this.key = key;
        this.resultado = new int[3];
        this.listaApostas = new HashMap<Apostador,ArrayList<Aposta>>();
    }
    
    
    
    
    
    //Gets
    public Integer getKey(){return this.key;}
    public ArrayList<Float> getOdd() {
        return this.odd;
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
    
   
    //Sets
    public void setOdd(ArrayList<Float> odd){
        for(Float o: odd) this.odd.add(o);
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
        addObserver(b);
    }
    
    //Registar Evento 
    public Aposta apostarAqui( Apostador apostador, double valor, String equipa ){
        if(!this.isOpen()) return null;
        if( equipa.equals(this.eq1) || equipa.equals(this.eq2) ){
            Aposta novaBid = new Aposta( valor, equipa, this.odd );
            if(listaApostas.containsKey(apostador)){
                listaApostas.get(apostador).add(novaBid);
            }
            else{
                ArrayList<Aposta> ap = new ArrayList<Aposta>();
                ap.add(novaBid);
                listaApostas.put(apostador, ap);
            }
            
            return novaBid;
        }
            return null;
        
    }
    
    //verificar se é possivel apostar 
    public boolean isOpen(){
        return this.aberto;
    }
    
    
    
    public void terminarEvento(int result[]){
        this.resultado = result;
        for(Apostador k : this.listaApostas.keySet()){
            for(Aposta ap : listaApostas.get(k)){
                boolean ganhou = false;
                if(result[0] > result[1] && ap.getNomeDaEquipa().equals(eq1)){
                    double bc = ap.getValorApostado()*ap.getOdd().get(0);
                    k.adicionarBetcoins(bc);
                }
                    
                else if(result[1]>result[0] && ap.getNomeDaEquipa().equals(eq2)){
                    double bc = ap.getValorApostado()*ap.getOdd().get(3);
                    k.adicionarBetcoins(bc);
                }     
            }
        }
        setChanged();
        notifyObservers();
        deleteObservers();
        clearChanged();     
    }
        
}
