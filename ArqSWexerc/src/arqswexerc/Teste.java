/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqswexerc;

import Business.Facade;
import Presentation.BookieUI;

/**
 *
 * @author xavier
 */
public class Teste {
    public static void main(String[] args) throws InterruptedException{
        Facade f = new Facade();
        BookieUI BUI = new BookieUI(f);
        BUI.start();
        BUI.join();
    }
    
}
