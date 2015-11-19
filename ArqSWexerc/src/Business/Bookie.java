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
public class Bookie implements MyObserver {
    private String usrname;
    private String passwd;
    //private HashMap<Integer, Evento> eventosEmPosse;
    private HashMap<Integer, Evento> interesses;
    private HashMap<Integer, Notificacao> notificacoes;
    
    
    public Bookie(String usr,String passwd){
        this.usrname = usr;
       // this.eventosEmPosse = new HashMap<Integer,Evento>();
        this.interesses = new HashMap<Integer,Evento>();
        this.notificacoes = new HashMap<Integer,Notificacao>();
        this.passwd = passwd;
    }
    
    
   /* public Bookie(String usr, HashMap<Integer, Evento> eventos){
        this.usrname = usr;
        this.eventos = eventos;
        this.interesses = new HashMap<Integer,Evento>();
        this.notificacoes = new HashMap<Integer,Notificacao>();
    }*/
    
    
    public String getUsrName(){
        return this.usrname;
    }
    public String getPasswd(){
        return this.passwd;
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
    public void interested(Integer k, Evento e){
        this.interesses.put(k, e);
        e.addInteressado(this);
    }
   /* public void closeEvent(Integer key, int result[]){
        this.eventosEmPosse.get(key).terminarEvento(result);
    }*/


    @Override
    public void update(Subject o, Object arg) {
        Evento e = (Evento) o;
        Notificacao n = (Notificacao)arg;
        notificacoes.put(e.getKey(), n);
        //System.out.println("Bookie:"+this.usrname+"foi notificado pelo evento:"+ e.getEq1()+"Vs"+e.getEq2());
        System.out.println("NOTIFICATION TO BOOKIE "+this.usrname+" :"+n.toString());
    }
    
}
