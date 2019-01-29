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
public class Problems {

    // Merge two sorted arrays
    public int[] mergeSorted(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int j = 0; // pointer for array a
        int k = 0; // pointer for array b

        for (int i = 0; i < (a.length + b.length); i++) {
            if (j < a.length && k < b.length) {
                if (a[j] < b[k]) {
                    c[i] = a[j];
                    j++;
                } else if (a[j] > b[k]) {
                    c[i] = b[k];
                    k++;
                } else if (a[j] == a[k]) {
                    c[i] = b[k];
                    c[i + 1] = a[j];

                    i += 2;
                    k++;
                    j++;
                }
            } else if (j < a.length) {
                c[i] = a[j];
                j++;
            } else {
                c[i] = b[k];
                k++;
            }
        }

        return c;
    } //-- end of merge two sorted arrays

    // Reorder entries so that even appears first then odd without allocating new memory
    public int[] sortEvenOdd(int[] a) {
        int i = 0, p = 0, tmp = 0;

        while (i < a.length) {
            if (a[i] % 2 == 0) {
                // Even number encounterd
                if (i != 0) {
                    // Perfom swap
                    tmp = a[p];
                    a[p] = a[i];
                    a[i] = tmp;
                    p++;
                } else {
                    p++;
                }
            }
            i++;
        }
        return a;
    }// --end of sortEvenOdd

    // Given sorted array, determine if there is a pair of numbers that sum the input x
    public boolean checkSumInArray(int[] numbers, int x) {
        int i = 0;
        int j = 0;
        int r = numbers.length - 1;
        boolean flag = false;

        while (i < numbers.length) {
            if ((numbers[i] + numbers[r]) > x) {
                r--;
            } else if ((numbers[i] + numbers[r]) < x) {
                j++;
            } else if ((numbers[i] + numbers[r]) == x) {
                flag = true;
            }
            i++;
        }

        return flag;
    } // --end of checkSumInArray

    public boolean checkIfSynadrome(String word1, String word2) {

        boolean flag = true;
        if (word1.length() == word2.length()) {
            word1 = word1.toLowerCase();
            word2 = word2.toLowerCase();

            Hashtable<Character, Integer> ht1 = new Hashtable<>();
            Hashtable<Character, Integer> ht2 = new Hashtable<>();

            int i = 0;

            while (i < word1.length()) {
                if (ht1.containsKey(word1.charAt(i))) {
                    ht1.put(word1.charAt(i), ht1.get(word1.charAt(i)) + 1);
                } else {
                    ht1.put(word1.charAt(i), 1);
                }

                if (ht2.containsKey(word2.charAt(i))) {
                    ht2.put(word2.charAt(i), ht2.get(word2.charAt(i)) + 1);
                } else {
                    ht2.put(word2.charAt(i), 1);
                }
                i++;
            }// --end of while

            Set<Character> keys = ht1.keySet();

            // for-each loop
            for (Character key : keys) {
                if (!(ht2.containsKey(key) && ht2.containsValue(ht1.get(key)))) {
                    flag = false;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }// --end of checkIfSynadrome

}
