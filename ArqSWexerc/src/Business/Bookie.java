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
    private HashMap<Integer, Evento> notificacoes;
    
    
    public Bookie(String usr, HashMap<Integer, Evento> eventos){
        this.usrname = usr;
        this.eventos = eventos;
        this.interesses = new HashMap<Integer,Evento>();
        this.notificacoes = new HashMap<Integer,Evento>();
    }
    
    
    public String getUsrName(){
        return this.usrname;
    }
    public HashMap<Integer,Evento> getInterresses(){
        return this.interesses;
    }
    public HashMap<Integer,Evento> getNotificacoes(){
        return this.notificacoes;
    }
    public void setUsrName(String name){
        this.usrname = name;
    }
    public void newEvent(ArrayList<Float> odd, String eq1, String eq2, int[] resultado,
            GregorianCalendar inicio, GregorianCalendar fim, Integer key){
        Evento e = new Evento(odd,eq1,eq2,inicio,fim,key);
        this.eventos.put(key, e);
    }
    public void interested(Integer k){
        this.interesses.put(k, this.eventos.get(k));
        this.eventos.get(k).addInteressado(this);
    }
    public void closeEvent(Integer key, int result[]){
        this.eventos.get(key).terminarEvento(result);
    }

    @Override
    public void update(Observable o, Object arg) {
        Evento e = (Evento) o;
        interesses.remove(e.getKey());
        notificacoes.put(e.getKey(), e);
        System.out.println("Bookie:"+this.usrname+"foi notificado pelo evento:"+ e.getEq1()+"Vs"+e.getEq2());
    }
    
}
