/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysmain;

import java.util.*;

/**
 *
 * @author Marco Gonzalez
 */
public class ArraysMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // One way of declaring array
        int[] numbers = {1,2,3};
        
        // sorting array
        Arrays.sort(numbers);
        
        // chars array
        char[] characters = new char[10];
        
        // String array
        String[] d = new String[10]; 
        
        // boolean array
        boolean[] bool = new boolean[10];
        
        ArrayList<Integer> ints = new ArrayList<>(); 
        ints.add(1);
        ints.add(4);
        ints.add(2);
        
        // From least to greatest (using merge sort) 
        Collections.sort(ints); 
        
        // From greatest to least
        Collections.reverse(ints);
        
        StringBuilder p = new StringBuilder(); 
        
    }
    
}
