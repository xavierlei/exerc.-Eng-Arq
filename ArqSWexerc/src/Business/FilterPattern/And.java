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
public class And implements Criteria{
    
    private Criteria crit1;
    private Criteria crit2;
    
    public And(Criteria crit1, Criteria crit2){
        this.crit1 = crit1;
        this.crit2 = crit2;
    }

    @Override
    public ArrayList<Object> meetCriteria(ArrayList<Object> objects) {
        ArrayList<Object> resCrit1 = crit1.meetCriteria(objects);
        return crit2.meetCriteria(resCrit1);
    }

    @Override
    public Criteria clone() {
        return new And(this.crit1.clone(),this.crit2.clone());
    }
    
   
    
}
