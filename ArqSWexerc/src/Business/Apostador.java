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
public class Apostador {
    private String nome;
    private double saldoBetCoins;
    private ArrayList<Aposta> historicoApostas;

    public Apostador(String nome, double saldoBetCoins, ArrayList<Aposta> historicoApostas) {
        this.nome = nome;
        this.saldoBetCoins = saldoBetCoins;
        this.historicoApostas = historicoApostas;
    }
    
    public void adicionarBetcoins( double bc ){//coiso
        if( bc > 0 ){
            this.saldoBetCoins += bc;
        }
    }
    
    public void realizarAposta( Aposta a, double valor, String equipa ){
        this.historicoApostas.add(a);
        a.apostarAqui(this, valor, equipa);
    }
    
    
    
    
    
    
    
}
