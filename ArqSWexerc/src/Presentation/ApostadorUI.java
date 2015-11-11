/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Apostador;
import Business.Evento;
import Business.Facade;
import Business.Notificacao;
import java.util.Scanner;

/**
 *
 * @author xavier
 */
public class ApostadorUI {
    
    private Facade facade;
    private Apostador apostador;
    
    public ApostadorUI(Facade f, Apostador ap){
        this.facade=f;
        //this.apostador = new Apostador("Xavier", 50000);
        //f.adicionarApostador(apostador);
        this.apostador= ap;
    }
    
    private void switchBet(String[] tokens){
        this.facade.fazerAposta(new Integer(tokens[1]),
                this.apostador.getNome(), tokens[2], new Float(tokens[3]));
    }
    
    public void run(){
        
        boolean b = true;
        Scanner input = new Scanner(System.in);
        System.out.println("APOSTADOR USER INTERFACE");
        System.out.println("print 'man' for help ");
        System.out.print(">");
        String cmd = input.nextLine();
        while(b){
            String delims = "[ ]+";
            String[] tokens = cmd.split(delims);
            switch(tokens[0]){
                case "list":
                    for(Evento e : this.facade.ConsultarEventos()){
                        System.out.println(e.toString());
                    }
                    break;
                case "history":
                    //System.out.println("printa 1");
                    for(Evento e : apostador.getHistorico()){
                        //System.out.println("printa 2");
                        System.out.println(e.toString());
                    }
                    break;
                case "bet":
                    this.facade.fazerAposta(new Integer(tokens[1]), this.apostador.getNome(),
                            tokens[2], new Float(tokens[3]));
                    break;
                case "notifications":
                    //System.out.println("printa 1");
                    for(Notificacao n: this.apostador.getNotificacoes().values()){
                        //System.out.println("printa 2");
                        System.out.println(n.toString());
                        //System.out.println("printa 3");
                    }
                    break;
                case "exit":
                    b = false;
                    break;
                case "man":
                    System.out.println("list");
                    System.out.println("bet key eq value");
                    System.out.println("notifications");
                    System.out.println("history");
                    System.out.println("man");
                    break;
                default:
                    System.out.println("unknown command");
                    break;
                
                
            }
            
            if(b){
              System.out.println("APOSTADOR USER INTERFACE");
              System.out.println("print 'man' for help ");
              System.out.print(">");
              cmd = input.nextLine(); 
          }
            
        }
            
    }
    
}
