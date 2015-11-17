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
    
    
    
    public Bookie bookieRegister(String usr,String passwd){
        Bookie b = new Bookie(usr,passwd);
        if(!this.bookies.containsKey(b)){
            this.bookies.put(usr, b);
            return b;
        }
        return null;    
    }
    public Bookie bookieLogIn(String usr, String passwd){
        if(this.bookies.containsKey(usr) && this.bookies.get(usr).getPasswd().equals(passwd))
            return this.bookies.get(usr);
        else return null;
    }
    public Apostador apostadorRegister(String usr, String passwd,double saldo){
        if(!this.apostadores.containsKey(usr)){
            Apostador ap = new Apostador(usr, passwd,saldo);
            this.apostadores.put(usr, ap);
            return ap;
        }
        return null;
    }
    public Apostador apostLogin(String usr, String passwd){
        if(this.apostadores.containsKey(usr) && this.apostadores.get(usr).getPasswd().equals(passwd))
            return this.apostadores.get(usr);
        else return null;
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
    public boolean TerminarEvento(Integer cod, int eq1, int eq2, String bookie) {
        if(this.eventos.get(cod).getBookie().getUsrName().equals(bookie)){
            int result[] = {eq1,eq2};
            this.eventos.get(cod).terminarEvento(result);
            return true;
        }
        else {
            return false;
        }
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
    
    
    
}
