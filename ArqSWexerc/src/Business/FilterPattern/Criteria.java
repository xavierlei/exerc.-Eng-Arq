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
public interface Criteria {
    public ArrayList<Evento> meetCriteria(ArrayList<Evento> evento);
}
