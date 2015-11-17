/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqswexerc;

import Business.Apostador;
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
        this.facade.bookieRegister("Zé_tone","123");
        this.facade.bookieRegister("José_tone","123");
        this.facade.bookieRegister("António_josé","123");
        this.facade.bookieRegister("Tony_John","123");
        this.facade.bookieRegister("John_Johnson","123");
        
        Apostador a1 = this.facade.apostadorRegister("José_Silva","123",30000);
        Apostador a2 = this.facade.apostadorRegister("Paulo_Cardoso","123",4000);
        Apostador a3 = this.facade.apostadorRegister("Mário_Anónimo","123",30000);
        Apostador a4 = this.facade.apostadorRegister("Pedro_Pessoa","123",500);
   
        Odd odd1 = new Odd(2,3,5);
        int [] res1 = {0,0};
        GregorianCalendar inicio, fim;
         inicio = new GregorianCalendar();
         fim = new GregorianCalendar();
        facade.AbrirEvento(odd1, "braga", "barcelos",res1,inicio,fim, facade.getBookie("Zé_tone"));
        facade.AbrirEvento(odd1, "porto", "barcelos",res1,inicio,fim, facade.getBookie("Zé_tone"));
        facade.AbrirEvento(odd1, "braga", "guimaraes",res1,inicio,fim, facade.getBookie("Tony_John"));
        facade.AbrirEvento(odd1, "viana", "barcelos",res1,inicio,fim, facade.getBookie("Tony_John"));
        facade.AbrirEvento(odd1, "cenas", "porto",res1,inicio,fim, facade.getBookie("John_Johnson"));
        facade.AbrirEvento(odd1, "braga", "cenas",res1,inicio,fim, facade.getBookie("John_Johnson"));
        
        facade.interested(a1.getNome(), 0);
        facade.interested(a2.getNome(), 0);
        
        
        facade.fazerAposta(0, a1.getNome(), "braga", 750);
        facade.fazerAposta(0, a2.getNome(), "barcelos", 100);
        facade.fazerAposta(0, a3.getNome(), "braga", 25000);
        facade.fazerAposta(0, a4.getNome(), "braga", 250);

        facade.fazerAposta(1, a1.getNome(), "porto", 750);
        facade.fazerAposta(1, a2.getNome(), "barcelos", 100);
        facade.fazerAposta(1, a3.getNome(), "porto", 25000);
        facade.fazerAposta(1, a4.getNome(), "barcelos", 250);
        
        facade.fazerAposta(2, a1.getNome(), "porto", 7500);
        facade.fazerAposta(2, a2.getNome(), "barcelos", 10);
        facade.fazerAposta(2, a3.getNome(), "porto", 250);
        facade.fazerAposta(2, a4.getNome(), "barcelos", 25);
        
    }
    
    
}
