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
    private ArrayList<Evento> historicoEventos;

    public Apostador(String nome, double saldoBetCoins) {
        this.nome = nome;
        this.saldoBetCoins = saldoBetCoins;
        this.historicoEventos = new ArrayList<Evento>();
    }

    public String getNome() {
        return nome;
    }
    
    public ArrayList<Evento> getHistorico(){return this.historicoEventos;}
    
    
    
    
    public void adicionarBetcoins( double bc ){//coiso
        if( bc >= 0 ){
            this.saldoBetCoins += bc;
        }
    }
    
    public void realizarAposta( Evento event, double valor, String equipa ){
        
        if(valor < this.saldoBetCoins){
            this.historicoEventos.add( event );
            event.apostarAqui(this, valor, equipa);
        }
        
    }
    
    
    
    
    
    
    
}
