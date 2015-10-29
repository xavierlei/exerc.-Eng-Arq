/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 *
 * @author xavier
 */
public class Bookie {
    private String usrname;
    private HashMap<Integer, Evento> eventos;
    public Bookie(String usr, HashMap<Integer, Evento> e){
        this.usrname = usr;
        this.eventos = e;
    }
    public String getUsrName(){
        return this.usrname;
    }
    public void setUsrName(String name){
        this.usrname = name;
    }
    public void newEvent(ArrayList<Float> odd, String eq1, String eq2, int[] resultado,
            GregorianCalendar inicio, GregorianCalendar fim, Integer key){
        Evento e = new Evento(odd,eq1,eq2,resultado,inicio,fim,key);
        this.eventos.put(key, e);
    }
    public void interested(Integer k){
        this.eventos.get(k).addInteressado(this);
    }
    
}
