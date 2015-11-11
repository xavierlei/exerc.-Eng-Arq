/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Apostador;
import Business.Bookie;
import Business.Facade;
import java.util.Scanner;

/**
 *
 * @author xavier
 */
public class GenericUI {
    private Facade facade;
    private Bookie usr;
    private Apostador apostador;
    
    public GenericUI(Facade f){
        this.facade = f;
        this.apostador = new Apostador("Xavier Apostador", 50000);
        f.adicionarApostador(apostador);
        this.usr = this.facade.bookieRegister("Xavier Bookie");
    }
    
    public void run(){
        boolean b = true;
        Scanner input = new Scanner(System.in);
        System.out.println("GENERIC USER INTERFACE");
        System.out.println("Bookie - log as a Bookie");
        System.out.println("Apostador - log as Apostador");
        System.out.println("exit - exit the system");
        System.out.println("print 'man' for help ");
        System.out.print(">");
        String cmd = input.nextLine();
        while(b){
            String delims = "[ ]+";
            String[] tokens = cmd.split(delims);
            switch(tokens[0]){
                case "Bookie":
                    BookieUI bui = new BookieUI(facade, usr);
                    bui.run();
                    break;
                case "Apostador":
                    ApostadorUI aui = new ApostadorUI(facade, apostador);
                    aui.run();
                    break;
                case "exit":
                    b = false;
                    break;
                default:
                    System.out.println("unknown command");
                    break;
            }
            
            if(b){
              System.out.println("GENERIC USER INTERFACE");
              System.out.println("Bookie - log as a Bookie");
              System.out.println("Apostador - log as Apostador");
              System.out.println("exit - exit the system");
              System.out.print(">");
              cmd = input.nextLine(); 
          } 
        }
    }
    
}
