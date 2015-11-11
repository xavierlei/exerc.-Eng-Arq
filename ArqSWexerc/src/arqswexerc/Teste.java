/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqswexerc;

import Business.Facade;
import Presentation.ApostadorUI;
import Presentation.BookieUI;
import Presentation.GenericUI;

/**
 *
 * @author xavier
 */
public class Teste {
    public static void main(String[] args) throws InterruptedException{
        Facade f = new Facade();
        
        GenericUI gui = new GenericUI(f);
        gui.run();
        /*
        BookieUI BUI = new BookieUI(f);
        ApostadorUI AUI = new ApostadorUI(f);
        AUI.run();
        BUI.join();*/
    }
    
}
