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
    public ArrayList<Object> meetCriteria(ArrayList<Object> objects) {
        ArrayList<Object> res = new ArrayList<Object>();
        
        for(Object o : objects){
            Evento e = (Evento)o;
            if(e.isOpen())
                res.add(e);
        }
        return res;
    }

    @Override
    public Criteria clone() {
        return new Aberto();
    }
    

}
