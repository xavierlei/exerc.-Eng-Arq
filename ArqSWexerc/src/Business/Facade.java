/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Presentation.BusinessPresentation;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 *
 * @author xavier
 */
public class Facade implements BusinessPresentation {
    
    private HashMap<String, Bookie> bookies;
    private HashMap<String, Apostador> apostadores;
    private HashMap<Integer, Evento> eventos;

    @Override
    public void AbrirAposta(ArrayList<Float> odd, String eq1, String eq2, int[] resultado, GregorianCalendar inicio, GregorianCalendar fim, Integer key) {
        Evento e = new Evento(odd,eq1,eq2, resultado,  inicio,  fim,  key);
        this.eventos.put(key, e);
    }

    @Override
    public void FecharAposta(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void TerminarAposta(String cod, int eq1, int eq2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddFundo(float val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RetirarFundo(float val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float ConsltarFundo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ComprarCoins(String apostador, float val) {
        this.apostadores.get(apostador).adicionarBetcoins(val);
        return true;
    }

    

    @Override
    public ArrayList<Evento> ConsultarApostas() {
        ArrayList<Evento> res = new ArrayList<Evento>();
        for(Integer k : this.eventos.keySet()){
            res.add(eventos.get(k));
        }
        return res;
    }

    @Override
    public boolean FazerApostas(Integer cod,String apostador, String eq, float val) {
        if(!eventos.get(cod).isOpen()) return false;
        apostadores.get(apostador).realizarAposta(eventos.get(cod), val, eq);
        return true;
    }

    @Override
    public void newBookie(String usr) {
        Bookie b = new Bookie(usr, this.eventos);
        bookies.put(usr, b);
    }
    
}
