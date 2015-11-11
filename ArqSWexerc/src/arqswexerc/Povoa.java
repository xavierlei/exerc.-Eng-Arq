/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqswexerc;

import Business.Facade;
import Business.Odd;
import java.util.GregorianCalendar;

/**
 *
 * @author xavier
 */
public class Povoa {
    
    private Facade facade;
    
    public Povoa(Facade f){
        this.facade = f;
    }
    
    public void povoamento(){
        this.facade.bookieRegister("Zé tone");
        this.facade.bookieRegister("José tone");
        this.facade.bookieRegister("António josé");
        this.facade.bookieRegister("Tony John");
        this.facade.bookieRegister("John Johnson");
        
        this.facade.apostadorRegister("José Silva",30000);
        
        Odd odd1 = new Odd(2,3,5);
        int [] res1 = {0,0};
        GregorianCalendar inicio, fim;
         inicio = new GregorianCalendar();
         fim = new GregorianCalendar();
        facade.AbrirEvento(odd1, "braga", "barcelos",res1,inicio,fim, facade.getBookie("Zé tone"));
        facade.AbrirEvento(odd1, "porto", "barcelos",res1,inicio,fim, facade.getBookie("Zé tone"));
        facade.AbrirEvento(odd1, "braga", "guimaraes",res1,inicio,fim, facade.getBookie("Tony John"));
        facade.AbrirEvento(odd1, "viana", "barcelos",res1,inicio,fim, facade.getBookie("Tony John"));
        facade.AbrirEvento(odd1, "cenas", "porto",res1,inicio,fim, facade.getBookie("John Johnson"));
        facade.AbrirEvento(odd1, "braga", "cenas",res1,inicio,fim, facade.getBookie("John Johnson"));
        
       
    }
    
    
}
