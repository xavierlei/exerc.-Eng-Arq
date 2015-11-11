/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Bookie;
import Business.Evento;
import Business.Facade;
import Business.Notificacao;
import Business.Odd;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author xavier
 */
public class BookieUI {
    
    private Facade facade;
    private Bookie usr;
    
    public BookieUI(Facade f, Bookie b){
        this.facade = f;
        System.out.println("criou o cenas");
        //this.usr = this.facade.bookieRegister("Xavier");
        this.usr = b;
    }
    
    private void switchNewEvent(String[] s){
        int [] res = {0,0};
        Odd o = new Odd(new Integer(s[3]),new Integer(s[4]),new Integer(s[5]));
        GregorianCalendar inicio = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        inicio.set(new Integer(s[6]),new Integer(s[7]), new Integer(s[8]));
        fim.set(new Integer(s[9]),new Integer(s[10]), new Integer(s[11]));
        facade.AbrirEvento(o,s[1],s[2],res,inicio,fim,usr);
    }
    private void switchCloseEvent(String[] s){
        facade.TerminarEvento(new Integer(s[1]), new Integer(s[2]), new Integer(s[3]));
    }
    private void switchList(String[] s){
        for(Evento e : facade.ConsultarEventos()){
            System.out.println(e.toString());
        }
    }

    private boolean login(String usr){return true;}
    
    public void run(){
        boolean b = true;
        Scanner input = new Scanner(System.in);
        System.out.println("BOOKIE USER INTERFACE");
        System.out.println("print 'man' for help ");
        System.out.print(">");
        String cmd = input.nextLine();
        
        while(b){
          String delims = "[ ]+";
          String[] tokens = cmd.split(delims);
          switch(tokens[0]){                  
              case "newEvent":
                  switchNewEvent(tokens);
                  break;
                  
              case "endEvent":
                  switchCloseEvent(tokens);
                  break;
                  
              case "list":
                  switchList(tokens);
                  break;
                  
              case "interest":
                  Integer evento = new Integer(tokens[1]);
                  System.out.println("o num é: "+evento);
                  this.facade.interested(usr.getUsrName(), evento);
                  break;
                  
              case "man":
                  System.out.println("  newEvent eq1 eq2 odd odd odd inicio fim");
                  System.out.println("  changeOdd key odd odd odd");
                  System.out.println("  endEvent key resultEq1 resultEq2");
                  System.out.println("  list arg");
                  System.out.println("  interest key");
                  System.out.println("  notifications");
                  System.out.println("  exit");
                  break;
              case "changeOdd":
                  Odd odd = new Odd(new Integer(tokens[2]), new Integer(tokens[3]),new Integer(tokens[4]));
                  this.facade.alteraOdd(new Integer(tokens[1]), odd);
                  break;
              case "notifications":
                  for(Notificacao n : this.facade.getNotificacoes(usr.getUsrName()).values()){
                      System.out.println(n.toString());
                  }
                  break;
                  
              case "exit":
                  System.out.println("exitou");
                  b = false;
                  break;
                  
              default:
                  System.out.println("unknown command");
                  break;
          }
            
            
          if(b){
              System.out.println("BOOKIE USER INTERFACE");
              System.out.println("print 'man' for help ");
              System.out.print(">");
              cmd = input.nextLine(); 
          }  
        } 
    }
}
