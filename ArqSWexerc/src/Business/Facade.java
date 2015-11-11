/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Presentation.BusinessPresentation;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author xavier
 */
public class Facade implements BusinessPresentation {
    
    private HashMap<String, Bookie> bookies;
    private HashMap<String, Apostador> apostadores;
    private HashMap<Integer, Evento> eventos;
    private int idCounter;

    public Facade() {
        this.bookies = new HashMap<String, Bookie>();
        this.apostadores = new HashMap<String, Apostador>();
        this.eventos = new HashMap<Integer, Evento>();
        this.idCounter = 0;
    }
    
    
    
    public Bookie bookieRegister(String usr){
        Bookie b = new Bookie(usr);
        if(!this.bookies.containsKey(b)){
            this.bookies.put(usr, b);
            return b;
        }
        return null;    
    }
    public Apostador apostadorRegister(String usr, double saldo){
        Apostador ap = new Apostador(usr, saldo);
        return ap;
    }
    public int getIdCounter(){return this.idCounter;}
    public Evento getEvento( int key ){
        return this.eventos.get(key);
    }
    public Bookie getBookie(String usr){ return this.bookies.get(usr);}
    
    public HashMap<Integer,Notificacao> getNotificacoes(String bookie){
        return this.bookies.get(bookie).getNotificacoes();
    }
    public void adicionarApostador( Apostador a ){
        this.apostadores.put(a.getNome(), a);
    }
    public void adicionarBookie(Bookie b){
        this.bookies.put( b.getUsrName(), b);
    }
    
    public void printApostadores( Integer key ){
        for(Apostador a : this.eventos.get(key).getApostas().keySet()){
            System.out.println( a.getNome() );
        }
    }
    
    public void interested(String bookie,Integer k){
        if(!this.bookies.containsKey(bookie)) return;
        Bookie b = this.bookies.get(bookie);
        b.interested( k, this.eventos.get(k) );
    }
    /*
    public void printApostasEventos(){
        for(Integer k : this.eventos.keySet()){
            this.eventos.get(k).printApostas();
        }
    }
    */
    
    public void adicionarEvento( Evento e, Integer key ){
        this.eventos.put( key, e);
    }
    
    

    @Override
    public void AbrirEvento(Odd odd, String eq1, String eq2,
            int[] resultado, GregorianCalendar inicio, GregorianCalendar fim, Integer key,Bookie b) {
        Evento e = new Evento(odd,eq1,eq2, inicio,  fim,  key,b);
        this.eventos.put(key, e);
        idCounter++;
    }
    public void AbrirEvento(Odd odd, String eq1, String eq2,
            int[] resultado, GregorianCalendar inicio, GregorianCalendar fim, Bookie b) {
        Evento e = new Evento(odd,eq1,eq2, inicio,  fim,  idCounter,b);
        this.eventos.put(e.getKey(), e);
        idCounter++;
    }

    @Override
    public void FecharEvento(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void TerminarEvento(Integer cod, int eq1, int eq2) {
        int result[] = {eq1,eq2};
        this.eventos.get(cod).terminarEvento(result);
    }

    @Override
    public void AddFundo(float val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RetirarFundo(float val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float ConsltarFundo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ComprarCoins(String apostador, float val) {
        this.apostadores.get(apostador).adicionarBetcoins(val);
        return true;
    }

    

    @Override
    public ArrayList<Evento> ConsultarEventos() {
        ArrayList<Evento> res = new ArrayList<Evento>();
        for(Integer k : this.eventos.keySet()){
            res.add(eventos.get(k));
        }
        return res;
    }

    @Override
    public boolean fazerAposta(Integer cod_evento, String apostador, String eq, float val) {
        
        //
        if( !eventos.get(cod_evento).isOpen() ) return false;
        
        this.apostadores.get(apostador).realizarAposta(eventos.get(cod_evento), val, eq);
        return true;
    }

    @Override
    public void adicionarBookie(String usr) {
        Bookie bk = new Bookie(usr,this.eventos);
        bookies.put(usr, bk);
    }

    public void alteraOdd(Integer key, Odd odd){
        this.eventos.get(key).setOdd(odd);
    }
    
    
    /*
    public void subMenuApostador( Apostador apostador ){
        
        int aux, sair=0;
        while(true){
            
            System.out.println("0 - sair para Menu Geral");
            System.out.println("1 - Consultar Eventos "); //e faz aposta
            System.out.println("2 - Consultar Saldo  ");
            System.out.println("3 - Consultar Historico de Apostas  ");
            System.out.print(">");
            Scanner opt = new Scanner(System.in);
            aux = opt.nextInt();
            System.out.println("Opção escolhida: "+ aux);
            
            switch( aux ){
                case 0 : 
                    sair = 1;
                    break;
                case 1 : // Apostar em Evento
                    int evento = consultarEventos( );
                    this.fazerAposta( evento, apostador.getNome(), "Porto", 23 );//porto ganha
                    break;                
                case 2 : //consultar Saldo
                    System.out.println( apostador.getNome() +" saldo: "+ apostador.getSaldo() );
                    break;
                case 3 :
                    System.out.println( apostador.historicoDeApostasToString() );
                    break;
                default:
                    break;
            }
           if(sair == 1){break;} 
      }
        
    }
    
    
    
    public int consultarEventos(){
        int i;
        ArrayList<Evento> eventosDisponiveis = this.ConsultarEventos();//sao keys
        ArrayList<Integer> opts = new ArrayList<Integer>();
        
        for( i=0; i < eventosDisponiveis.size() ;i++ ){
            System.out.println( "op: "+ i + " - " + eventosDisponiveis.get(i).getKey() );
            opts.add(i, eventosDisponiveis.get(i).getKey());//guarda cod evento
        }
        
        int aux ;
            
        System.out.print("escolha evento> ");
        Scanner opt = new Scanner(System.in);
        aux = opt.nextInt();
        System.out.println("Cod do Evento escolhido: " + opts.get(aux));
            
        
      return opts.get(aux);
    }
    */
    
    
    
    
   
    
}
