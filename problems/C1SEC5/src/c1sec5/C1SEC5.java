/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1sec5;

/**
 *
 * @author Marco
 */
public class C1SEC5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 2; 
        int b = 4; 
        
        a = a ^ b; 
        b = b ^ a; 
        a = b ^ a; 
        
        System.out.println(a);
        System.out.println(b);
    }
    
}
