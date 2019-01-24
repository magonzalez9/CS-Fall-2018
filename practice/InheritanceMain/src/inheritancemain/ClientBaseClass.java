/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancemain;

/**
 *
 * @author Marco Gonzalez
 */
public class ClientBaseClass {
    private int id; 
    
    public ClientBaseClass (int id){
        this.id = id; 
    }
    
    public String saySomething (){
        return "You can change this"; 
    }
    
    public final String sayOneTime(){
        return "You cannot change this"; 
    }
}
