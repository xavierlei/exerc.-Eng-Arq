/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author xavier
 */
public class Bookie implements Observer {
    private String usrname;
    private HashMap<Integer, Evento> eventos;
    private HashMap<Integer, Evento> interesses;
    private HashMap<Integer, Notificacao> notificacoes;
    
    
    public Bookie(String usr){
        this.usrname = usr;
        this.eventos = new HashMap<Integer,Evento>();
        this.interesses = new HashMap<Integer,Evento>();
        this.notificacoes = new HashMap<Integer,Notificacao>();
    }
    
    
    public Bookie(String usr, HashMap<Integer, Evento> eventos){
        this.usrname = usr;
        this.eventos = eventos;
        this.interesses = new HashMap<Integer,Evento>();
        this.notificacoes = new HashMap<Integer,Notificacao>();
    }
    
    
    public String getUsrName(){
        return this.usrname;
    }
    public HashMap<Integer,Evento> getInterresses(){
        return this.interesses;
    }
    public HashMap<Integer,Notificacao> getNotificacoes(){
        return this.notificacoes;
    }
    public void setUsrName(String name){
        this.usrname = name;
    }
    public void newEvent(Odd odd, String eq1, String eq2, int[] resultado,
        GregorianCalendar inicio, GregorianCalendar fim, Integer key){
        Evento e = new Evento(odd,eq1,eq2,inicio,fim,key,this);
        this.eventos.put(key, e);
    }
    public void interested(Integer k, Evento e){
        //if(!eventos.containsKey(k)) return;
        //this.interesses.put(k, this.eventos.get(k));
        //this.eventos.get(k).addInteressado(this);
        this.interesses.put(k, e);
        e.addInteressado(this);
    }
    public void closeEvent(Integer key, int result[]){
        this.eventos.get(key).terminarEvento(result);
    }

    @Override
    public void update(Observable o, Object arg) {
        Evento e = (Evento) o;
        Notificacao n = (Notificacao)arg;
        notificacoes.put(e.getKey(), n);
        //System.out.println("Bookie:"+this.usrname+"foi notificado pelo evento:"+ e.getEq1()+"Vs"+e.getEq2());
        System.out.println("NOTIFICATION: "+n.toString());
    }
    
}
