/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FilterPattern;

import Business.Evento;
import java.util.ArrayList;

/**
 *
 * @author xavier
 */
public class Dono implements Criteria{
    private String dono;
    
    public Dono(String dono){
        this.dono = dono;
    }

    @Override
    public ArrayList<Evento> meetCriteria(ArrayList<Evento> eventos) {
        ArrayList<Evento> res = new ArrayList<Evento>();
        for(Evento e : eventos){
            if(e.getBookie().getUsrName().equals(dono))
                res.add(e);
        }
        return res;
    }
    
}
