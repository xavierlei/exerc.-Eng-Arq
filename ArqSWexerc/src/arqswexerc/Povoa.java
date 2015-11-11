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
        this.facade.bookieRegister("Zé tone");
        this.facade.bookieRegister("José tone");
        this.facade.bookieRegister("António josé");
        this.facade.bookieRegister("Tony John");
        this.facade.bookieRegister("John Johnson");
        
        Apostador a1 = new Apostador("José Silva",30000);
        Apostador a2 = new Apostador("Paulo Cardoso",4000);
        Apostador a3 = new Apostador("Mário Anónimo Silva",30000);
        Apostador a4 = new Apostador("Pedro Pessoa",500);
        this.facade.adicionarApostador(a1);
        this.facade.adicionarApostador(a2);
        this.facade.adicionarApostador(a3);
        this.facade.adicionarApostador(a4);
        
        
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
