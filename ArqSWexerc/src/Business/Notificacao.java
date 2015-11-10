/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author xavier
 */
public class Notificacao {
    private Integer eventKey;
    private String msg;
    
    public Notificacao(Integer key, String msg){
        this.eventKey = key;
        this.msg = msg;
    }
    
    public String toString(){
        String s = "Evento: "+this.eventKey+" msg: "+this.msg;
        return s;
    }
}
