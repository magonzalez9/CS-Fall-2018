/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompractice;

import java.util.*;

/**
 *
 * @author Marco Gonzalez
 */
public class RandomPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Person marco = new Person("Marco", 22); 
        Person eru = new Person(marco); 
        eru.name = "eru"; 
        

        
        System.out.println(marco.toString());
        System.out.println(eru.toString());
        List<String> myList = new ArrayList<>();

        myList.add("marco");
        myList.add("penis");
        myList.add("marco");
        myList.add("marco");
        myList.add("confidence");

        countFrequency(myList);
    }

    public static void countFrequency(List<String> list) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        for (String str : list) {
            if (!ht.containsKey(str)) {
                ht.put(str, +1);
            } else {
                ht.put(str, ht.get(str) + 1);
            }
        }

        System.out.println(ht.toString());
    }
}
