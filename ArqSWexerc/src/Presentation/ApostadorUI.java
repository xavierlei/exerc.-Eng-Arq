/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Apostador;
import Business.Evento;
import Business.Facade;
import Business.FilterPattern.Aberto;
import Business.FilterPattern.And;
import Business.FilterPattern.Criteria;
import Business.FilterPattern.Dono;
import Business.FilterPattern.Fechado;
import Business.FilterPattern.Or;
import Business.Notificacao;
import java.util.ArrayList;
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
     private void switchList(String[] s){
        boolean good_syntax = true;
        if(s.length == 1){
            for (Evento e : this.facade.ConsultarEventos()){
                System.out.println(e.toString());
            }
        }
        else{
            Criteria c0; 
            switch(s[1]){
                    case "open":
                        c0 = new Aberto();
                        break;
                    case "closed":
                        c0 = new Fechado();
                        break;
                    default:
                        c0 = new Dono(s[1]);
                        break;
                } 
            for(int i = 2; i < s.length-1; i+=2){
                Criteria t;
                Criteria arg;
                switch(s[i+1]){
                    case "open":
                        arg = new Aberto();
                        break;
                    case "closed":
                        arg = new Fechado();
                        break;
                    default:
                        arg = new Dono(s[i+1]);
                        break;
                } 
                switch(s[i]){
                    case "and":
                        t = c0.clone();
                        c0 = new And(t,arg);
                        break;
                    case "or":
                        t = c0.clone();
                        c0 = new Or(t,arg);
                        break;
                    default:
                        good_syntax = false;
                        break;
                }
            }
            if(good_syntax){
                ArrayList<Object> objs = new ArrayList<Object>();
                for(Evento e : this.facade.ConsultarEventos()){
                    Object o = (Object)e;
                    objs.add(o);
                }
                for(Object o : c0.meetCriteria(objs)){
                    Evento e = (Evento)o;
                    System.out.println(e.toString());
                }
            }
            else{
                System.out.println("SYNTAX ERROR");
            }
        }
        
    }

    public void run(){
        
        boolean b = true;
        Scanner input = new Scanner(System.in);
        
        while(this.apostador == null && b){
            System.out.println("YOU MUST BE LOGED TO USE THE SYSTEM:");
            System.out.println("register username password credit");
            System.out.println("login username password");
            System.out.println("exit");
            System.out.print(">");
            String lg = input.nextLine();
            String delims = "[ ]+";
            String[] tokens = lg.split(delims);
            switch(tokens[0]){
                case "register":
                    if(tokens.length == 4)
                    this.apostador = this.facade.apostadorRegister(tokens[1], tokens[2], 
                                                                    new Double(tokens[3]));
                    break;
                case "login":
                    this.apostador = this.facade.apostLogin(tokens[1], tokens[2]);
                    break;
                case "exit":
                    b = false;
                    break;
                default:
                    System.out.println("ERROR: INVALID SYNTAX");
                    break;
            }
        }
        
        /*System.out.println("APOSTADOR USER INTERFACE");
        System.out.println("print 'man' for help ");
        System.out.print(">");
        String cmd = input.nextLine();*/
        while(b){
            
            System.out.println("APOSTADOR USER INTERFACE");
            System.out.println("print 'man' for help ");
            System.out.print(">");
            String cmd = input.nextLine();
            
            String delims = "[ ]+";
            String[] tokens = cmd.split(delims);
            switch(tokens[0]){
                case "list":
                    switchList(tokens);
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
                    for(Notificacao n: this.apostador.getNotificacoes()){
                        //System.out.println("printa 2");
                        System.out.println(n.toString());
                        //System.out.println("printa 3");
                    }
                    break;
                case "exit":
                    b = false;
                    break;
                case "man":
                    System.out.println(" list [open|closed|bookie_name] [and|or] [open|closed|bookie_name]");
                    System.out.println("bet key eq value");
                    System.out.println("notifications");
                    System.out.println("history");
                    System.out.println("balance");
                    System.out.println("man");
                    break;
                case "balance":
                    System.out.println("balance: "+this.apostador.getSaldo()+" BetCoins");
                    break;
                default:
                    System.out.println("unknown command");
                    break;
                
                
            }
            
            /*if(b){
              System.out.println("APOSTADOR USER INTERFACE");
              System.out.println("print 'man' for help ");
              System.out.print(">");
              cmd = input.nextLine(); 
          }*/
            
        }
            
    }
    
}
