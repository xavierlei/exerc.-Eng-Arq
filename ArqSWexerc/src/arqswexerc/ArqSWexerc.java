/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqswexerc;

import Business.Apostador;
import Business.Bookie;
import Business.Evento;
import Business.Facade;
import Business.Odd;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author xavier
 */
public class ArqSWexerc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Bookie bookie01 = new Bookie("António");
         Apostador apostador01 = new Apostador("Maria", 200 );
         Apostador apostador02 = new Apostador("Manuel", 200 );
         
         
         Odd odd01 = new Odd( 0.3,0.3,0.3 );
         GregorianCalendar inicio, fim;
         inicio = new GregorianCalendar();
         fim = new GregorianCalendar();
         Evento evento01 = new Evento(odd01,"Porto", "Benfica", inicio, fim, 123 );
         
         
        Facade casaDeApostas =  new Facade();
        casaDeApostas.adicionarApostador(apostador01);
        casaDeApostas.adicionarApostador(apostador02);
        casaDeApostas.adicionarBookie("António");
        casaDeApostas.adicionarEvento( evento01, 123 );
        
        
        int aux, sair=0;
        while(true){
            
            System.out.println("0 - sair");
            System.out.println("1 - adicionar evento key=123 ");
            System.out.println("2 - apostar ");
            System.out.println("3 - print Apostas ");
            System.out.println("4 - Mostrar interece no evento key=123 ");
            System.out.println("5 - terminar Evento ");
            System.out.print(">");
            Scanner opt = new Scanner(System.in);
            aux = opt.nextInt();
            System.out.println("Opção escolhida: "+ aux);
            
            switch( aux ){
                case 0 : 
                    sair=1;
                    break;
                case 1 : // adicionar evento
                    casaDeApostas.adicionarEvento(evento01, 123);
                    break;
                case 2 :// realizar aposta
                    casaDeApostas.subMenuApostador( apostador01 );
                    break;
                case 3 : // imprimir apostadores do evento
                    casaDeApostas.printApostadores( 123 );
                    casaDeApostas.printApostasEventos();
                    break;
                case 4 :
                    casaDeApostas.getEvento( 123 ).addInteressado(bookie01);
                    break;
                case 5 : //fechar evento
                    casaDeApostas.TerminarEvento( 123, 3, 2); //Porto ganha
                    break;
                default:
                    break;
            }
            
            
           if(sair==1){break;} 
      }
        
    }
    
    
    
    
}
