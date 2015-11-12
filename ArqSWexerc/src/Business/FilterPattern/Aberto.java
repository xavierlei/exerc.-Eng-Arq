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
public class Aberto implements Criteria{
    
   
    @Override
    public ArrayList<Evento> meetCriteria(ArrayList<Evento> eventos) {
        ArrayList<Evento> res = new ArrayList<Evento>();
        for(Evento e : eventos){
            if(e.isOpen())
                res.add(e);
        }
        return res;
    }
    
}
