/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class Bid {
    
    private double valorApostado;
    private String nomeDaEquipa;
    private ArrayList<Float> odd;

    public Bid(double valorApostado, String nomeDaEquipa, ArrayList<Float> odd) {
        this.valorApostado = valorApostado;
        this.nomeDaEquipa = nomeDaEquipa;
        this.odd = new ArrayList<Float>();
            for(Float o: odd) this.odd.add(o);
    }

    //  Gets
    public double getValorApostado(){
        return this.valorApostado;
    }
    public String getNomeDaEquipa(){
        return this.nomeDaEquipa;
    }
    public ArrayList<Float> getOdd() {
        return odd;
    }
    

    
    
    
    
}
