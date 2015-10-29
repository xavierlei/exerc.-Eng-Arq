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
public class Aposta {
    private ArrayList<Float> odd;
    private String eq1;
    private String eq2;
    private int resultado[];
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
    private HashMap<Apostador, Bid > apostadores; //key = apostador , value = Bid (que é um tuplo(valor,equipa))

    
    
    public Aposta(ArrayList<Float> odd, String eq1, String eq2, int[] resultado, GregorianCalendar inicio, GregorianCalendar fim) {
        this.odd = new ArrayList<Float>();
            for(Float o: odd) this.odd.add(o);
        this.eq1 = eq1;
        this.eq2 = eq2;
        this.resultado = resultado;
        this.inicio = inicio;
        this.fim = fim;
        
        this.apostadores = new HashMap<Apostador,Bid>();
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
    
    
   
    
    
    
    public boolean apostarAqui( Apostador apostador, double valor, String equipa ){
        if( equipa.equals(this.eq1) || equipa.equals(this.eq2) ){
            Bid b = new Bid(valor, equipa);
            this.apostadores.put(apostador, b);
        }else{
            return false;
        }
        return true;
    }
    
    
    public ArrayList<Apostador> terminarAposta(int resultado[]){
        ArrayList<Apostador> array = new ArrayList<>();
        
        return array;
    }
    
    
    
    
    
    
}
