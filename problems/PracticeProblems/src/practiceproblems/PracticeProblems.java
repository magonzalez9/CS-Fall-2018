/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproblems;

import java.util.*;

/**
 *
 * @author Marco
 */
public class PracticeProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Problems problem = new Problems();

        // Merge sorted arrays
        int[] a = {1, 3, 5, 5, 7, 9};
        int[] b = {20, 25, 30, 50};
        int[] result = problem.mergeSorted(a, b);
        System.out.println(Arrays.toString(result));

        // Sort arrays EVEN -> ODD
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evenSort = problem.sortEvenOdd(c);
        System.out.println(Arrays.toString(evenSort));

        // Check if sum EXISTS in array
        int[] d = {2, 3, 5, 8, 10, 12, 14, 14, 16, 20};
        boolean sumResult = problem.checkSumInArray(c, 10);
        System.out.println(sumResult);

        // Check if synadore
        boolean synResult = problem.checkIfSynadrome("peach", "cheap");
        System.out.println(synResult);
        
        Hashtable<String, Integer> ht = new Hashtable<>(); 
        
        Set<String> key = ht.keySet(); 
       
        
        for(String keys : key){
            System.out.println(ht.get(keys));
            
        }
        
        
    }

}
