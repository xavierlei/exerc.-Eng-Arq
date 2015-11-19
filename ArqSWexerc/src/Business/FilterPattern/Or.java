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
    public ArrayList<Object> meetCriteria(ArrayList<Object> objects) {
        ArrayList<Object> res1 = crit1.meetCriteria(objects);
        ArrayList<Object> res2 = crit2.meetCriteria(objects);
        for(Object o : res2){
            if(!res1.contains(o))
                res1.add(o);
        }
        return res1;
    }

    @Override
    public Criteria clone() {
        return new Or(this.crit1.clone(),this.crit2.clone());
    }
    
}
