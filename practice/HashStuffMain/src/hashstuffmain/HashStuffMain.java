/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashstuffmain;

import java.util.*;

/**
 *
 * @author Marco Gonzalez
 */
public class HashStuffMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, String> myMap = new HashMap<>();
        myMap.put("Marco", "Gonzalez"); 
        System.out.println(myMap.size());
        myMap.replace("Marco", "Antonio"); 
        
        Hashset<String, Integer> n = new Hashset<>(); 
        
        
        // Loop through a hash map
        for (HashMap.Entry<String, String> entry : myMap.entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }

}
