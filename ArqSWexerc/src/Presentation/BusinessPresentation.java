/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Apostador;
import Business.Bookie;
import Business.Evento;
import Business.Odd;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author xavier
 */
public interface BusinessPresentation {
    public void AbrirEvento(Odd odd, String eq1, String eq2, int[] resultado, 
            GregorianCalendar inicio, GregorianCalendar fim, Integer key,Bookie b);
    public void FecharEvento(String cod);
    public void TerminarEvento(Integer cod, int eq1, int eq2);
    public void AddFundo(float val);
    public boolean RetirarFundo(float val);
    public float ConsltarFundo();
    public boolean ComprarCoins(String apostador, float val);
    //public void newBookie(String usr);
    public void adicionarEvento( Evento e, Integer key );
    public void printApostadores( Integer key );
    public void adicionarApostador( Apostador a );
    public void adicionarBookie(String usr);
    
    //apagar mais tarde
    public void printApostasEventos();
    public void subMenuApostador( Apostador apostador );
    
    
    
    public ArrayList<Evento> ConsultarEventos();
    public boolean fazerAposta(Integer cod,String apostador, String eq, float val);
}
