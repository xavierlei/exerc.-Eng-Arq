/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Aposta;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author xavier
 */
public interface BusinessPresentation {
    public void AbrirAposta(String Eq1, String Eq2, ArrayList<Float> odd,
            GregorianCalendar inicio, GregorianCalendar fim);
    public void FecharAposta(String cod);
    public void TerminarAposta(String cod, int eq1, int eq2);
    public void AddFundo(float val);
    public boolean RetirarFundo(float val);
    public float ConsltarFundo();
    public float ComprarCoins(float val);
    public boolean CambiarCois(float val);
    public ArrayList<Aposta> ConsultarApostas();
    public boolean FazerApostas(String cod, String eq, float val);
}
