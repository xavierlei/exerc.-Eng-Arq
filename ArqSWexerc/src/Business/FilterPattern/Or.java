/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FilterPattern;

import Business.Evento;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author xavier
 */
public class Or implements Criteria{
    
    private Criteria crit1;
    private Criteria crit2;
    
    public Or(Criteria c1, Criteria c2){
        this.crit1 = c1;
        this.crit2 = c2;
    }

    @Override
    public ArrayList<Evento> meetCriteria(ArrayList<Evento> eventos) {
        ArrayList<Evento> res1 = crit1.meetCriteria(eventos);
        ArrayList<Evento> res2 = crit2.meetCriteria(eventos);
        for(Evento e : res2){
            if(!res1.contains(e))
                res1.add(e);
        }
        return res1;
    }   
}
