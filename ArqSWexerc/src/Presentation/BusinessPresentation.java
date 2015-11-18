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
    
    
    public void AbrirEvento(Odd odd, String eq1, String eq2,
            int[] resultado, GregorianCalendar inicio, GregorianCalendar fim, Bookie b);
    public boolean TerminarEvento(Integer cod, int eq1, int eq2,String bookie);
    public ArrayList<Evento> ConsultarEventos();
    public boolean fazerAposta(Integer cod,String apostador, String eq, float val);
}
