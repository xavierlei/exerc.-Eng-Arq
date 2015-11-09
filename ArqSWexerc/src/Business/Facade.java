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
    
    
    
    public void adicionarApostador( Apostador a ){
        this.apostadores.put(a.getNome(), a);
    }
    public void adicionarBookie(Bookie b){
        this.bookies.put( b.getUsrName(), b);
    }
    
    public void printApostadores( Integer key ){
        for(Apostador a : this.eventos.get(key).getApostas().keySet()){
            System.out.println(a.getNome());
        }
        
    }
    
    public void adicionarEvento( Evento e, Integer key ){
        this.eventos.put( key, e);
    }
    
    

    @Override
    public void AbrirEvento(ArrayList<Float> odd, String eq1, String eq2, int[] resultado, GregorianCalendar inicio, GregorianCalendar fim, Integer key) {
        Evento e = new Evento(odd,eq1,eq2, inicio,  fim,  key);
        this.eventos.put(key, e);
    }

    @Override
    public void FecharEvento(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void TerminarEvento(Integer cod, int eq1, int eq2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean fazerAposta(Integer cod, String apostador, String eq, float val) {
        
        //mudar, o apostador é que faz a aposta
        if(!eventos.get(cod).isOpen()) return false;
        this.apostadores.get(apostador).realizarAposta(eventos.get(cod), val, eq);
        return true;
    }

    @Override
    public void adicionarBookie(String usr) {
        Bookie bk = new Bookie(usr,this.eventos);
        bookies.put(usr, bk);
    }

    
   
    
}
