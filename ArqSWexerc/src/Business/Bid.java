/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Miguel
 */
public class Bid {
    
    private double valorApostado;
    private String nomeDaEquipa;

    public Bid(double valorApostado, String nomeDaEquipa) {
        this.valorApostado = valorApostado;
        this.nomeDaEquipa = nomeDaEquipa;
    }

    
    public void setValorApostado(double valorApostado) {
        this.valorApostado = valorApostado;
    }

    public void setNomeDaEquipa(String nomeDaEquipa) {
        this.nomeDaEquipa = nomeDaEquipa;
    }

    public double getValorApostado() {
        return valorApostado;
    }

    public String getNomeDaEquipa() {
        return nomeDaEquipa;
    }
    
    
    
    
    
}
