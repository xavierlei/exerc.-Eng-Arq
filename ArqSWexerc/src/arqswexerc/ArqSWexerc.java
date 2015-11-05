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
        // TODO code application logic here
        /*
        public void AbrirEvento(ArrayList<Float> odd, String eq1, String eq2, int[] resultado, 
                GregorianCalendar inicio, GregorianCalendar fim, Integer key);
        public void FecharEvento(String cod);
        public void TerminarEvento(String cod, int eq1, int eq2);
        public void AddFundo(float val);
        public boolean RetirarFundo(float val);
        public float ConsltarFundo();
        public boolean ComprarCoins(String apostador, float val);
        public void newBookie(String usr);

        public ArrayList<Evento> ConsultarEventos();
        public boolean fazerAposta(Integer cod,String apostador, String eq, float val);
        */
         Bookie bookie01 = new Bookie("António");
         Apostador apostador01 = new Apostador("Maria", 200 );
         
         ArrayList<Float> odd01 = new ArrayList<Float>();
         float a=(float) 0.8,b=(float) 1.2,c=(float) 0.9;
         odd01.add(a);
         odd01.add(b);
         odd01.add(c);
         GregorianCalendar inicio, fim;
         inicio = new GregorianCalendar();
         fim = new GregorianCalendar();
         Evento evento01 = new Evento(odd01,"Porto", "Benfica", inicio, fim, 123 );
         
         
        Facade casaDeApostas =  new Facade();
        casaDeApostas.adicionarApostador(apostador01);
        casaDeApostas.adicionarBookie(bookie01);
        casaDeApostas.adicionarEvento( evento01, 123 );
        
        
        int aux, sair=0;
        while(true){
            
            System.out.println("0 - sair");
            System.out.println("1 - adicionar evento ");
            System.out.println("2 - apostar ");
            System.out.println("3 - print Apostas ");
            System.out.println("Escolha um número entre 0-9");
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
                    casaDeApostas.fazerAposta( 123, "Maria", "Porto", 23 );
                    break;
                case 3 : // imprimir apostadores do evento
                    casaDeApostas.printApostadores( 123 );
                    break;
                default:
                    break;
            }
            
            
           if(sair==1){break;} 
      }
        
        
        
        
    }
    
    
    
    
    
}
