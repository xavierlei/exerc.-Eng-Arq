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
public class Aposta {
    
    private double valorApostado;
    private String nomeDaEquipa;
    //private ArrayList<Float> odd;
    private Odd oddMomento;
    
    private Boolean result_is_set;
    private Boolean result; // false = perdeu || true = ganhou
    

    public Aposta(double valorApostado, String nomeDaEquipa) {
        this.valorApostado = valorApostado;
        this.nomeDaEquipa = nomeDaEquipa;
        this.oddMomento = null;
        this.result_is_set = false;
        this.result = false;
        //this.odd = new ArrayList<Float>();
        //    for(Float o: odd) this.odd.add(o);
    }

    //  Sets
    public void setOddMomento(Odd oddMomento) {
        this.oddMomento = oddMomento;
    }

    
    
    //  Gets
    public double getValorApostado(){
        return this.valorApostado;
    }
    public String getNomeDaEquipa(){
        return this.nomeDaEquipa;
    }
    public Odd getOdd() {
        return this.oddMomento;
    }
    
    public Boolean resultIsSet(){ 
        return this.result_is_set;
    }

    public Boolean getResult() {
        return result;
    }

    
    
    //  Sets
    public void setResult_is_set(Boolean result_is_set) {
        this.result_is_set = result_is_set;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
    
    
    
    
    
}
