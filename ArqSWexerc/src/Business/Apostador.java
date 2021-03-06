/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.ObserverPattern.Subject;
import Business.ObserverPattern.MyObserver;
import java.util.ArrayList;



/**
 *
 * @author Miguel
 */
public class Apostador implements MyObserver {
    private String nome;
    private String passwd;
    private double saldoBetCoins;
    private ArrayList<Evento> historicoEventos; 
    private ArrayList<Aposta> historicoApostas;
    private ArrayList <Notificacao> notificacoes;
    

    public Apostador(String nome, String passwd, double saldoBetCoins) {
        this.nome = nome;
        this.saldoBetCoins = saldoBetCoins;
        this.historicoEventos = new ArrayList<Evento>();
        this.historicoApostas = new ArrayList<Aposta>();
        this.notificacoes = new ArrayList<Notificacao>();
        this.passwd = passwd;
    }

    public String getNome() {
        return nome;
    }
    public String getPasswd(){return this.passwd;}
    public double getSaldo(){
        return this.saldoBetCoins;
    }
    public ArrayList<Evento> getHistorico(){
        return this.historicoEventos;
    }
    
  public ArrayList<Notificacao> getNotificacoes(){
      return this.notificacoes;
  }
    
    
    public void adicionarBetcoins( double bc ){
        if( bc >= 0 ){
            this.saldoBetCoins += bc;
        }
    }
    
    public void realizarAposta( Evento event, double valor, String equipa ){
        
        if(valor < this.saldoBetCoins){
            this.historicoEventos.add( event );
            Aposta novaAposta = new Aposta( valor, equipa ); // Nova Aposta !!! ainda sem odd
            this.historicoApostas.add(novaAposta); // vai pró historico
            event.apostarAqui(this, novaAposta);// o Set da odd é feito aqui dentro - isto retorna Aposta ou null para quê?
            this.saldoBetCoins -= valor;
        }
        
    }
    
    public String historicoDeApostasToString(){
        StringBuilder str = new StringBuilder();
        for( Aposta a : this.historicoApostas ){
            str.append( "Equipa: " );
            str.append( a.getNomeDaEquipa() );
            str.append( "; valor apostado: " );
            str.append( a.getValorApostado() );
            str.append("BetCoins!");
            if( a.resultIsSet() ){
                if( a.getResult() ){
                    str.append(" \t GANHOU! ");
                }else{
                    str.append(" \t PERDEU T_T ");
                }
            }else{
                str.append(" \t *Pendente* ");
            }
            str.append("\n");
        }
        
        return str.toString();
    }

    @Override
    public void update(Subject o, Object arg) {
        Evento e = (Evento)o;
        Notificacao n = (Notificacao)arg;
        this.notificacoes.add(n);
        System.out.println("NOTIFICATION TO BETTER "+this.nome+": "+n.toString());
    }
    
    
    
    
    
}
