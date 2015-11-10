/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author miguelvieira
 */
public class Odd {
    
    private double equipaCasa;
    private double empate;
    private double equipaFora;
    
    

    public Odd(double equipaCasa, double empate, double equipaFora) {
        this.equipaCasa = equipaCasa;
        this.empate = empate;
        this.equipaFora = equipaFora;
    }

    
    
    public double getOddEquipaCasa() {
        return equipaCasa;
    }

    public double getOddEmpate() {
        return empate;
    }

    public double getOddEquipaFora() {
        return equipaFora;
    }
    
    
    
    
    
    
    
}
