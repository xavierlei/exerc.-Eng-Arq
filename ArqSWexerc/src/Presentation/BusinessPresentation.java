/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Evento;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author xavier
 */
public interface BusinessPresentation {
    public void AbrirEvento(ArrayList<Float> odd, String eq1, String eq2, int[] resultado, 
            GregorianCalendar inicio, GregorianCalendar fim, Integer key);
    public void FecharEvento(String cod);
    public void TerminarEvento(String cod, int eq1, int eq2);
    public void AddFundo(float val);
    public boolean RetirarFundo(float val);
    public float ConsltarFundo();
    public boolean ComprarCoins(String apostador, float val);
    public void newBookie(String usr);
    
    public ArrayList<Evento> ConsultarEventos();
    public boolean FazerApostas(Integer cod,String apostador, String eq, float val);
}
