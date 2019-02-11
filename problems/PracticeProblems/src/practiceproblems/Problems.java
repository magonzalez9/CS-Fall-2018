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
class Problems {

    // Merge two sorted arrays
    public int[] mergeSorted(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int j = 0; // pointer for array a
        int k = 0; // pointer for array b
        int i = 0;

        while (j < a.length && k < b.length) {
            if (a[j] < b[k]) {
                c[i] = a[j];
                j++;
            } else if (a[j] > b[k]) {
                c[i] = b[k];
                k++;
            } else {
                c[i] = a[j];
                c[i + 1] = b[k];
                j++;
                k++;
                i++;
            }
            i++;
        } // 

        while (j < a.length) {
            c[i] = a[j];
            j++;
            i++;
        }

        while (k < b.length) {
            c[i] = b[k];
            k++;
            i++;
        }

        return c;

    }

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
    } // --end of sortEvenOdd

    // Given sorted array, determine if there is a pair of numbers that sum the input x
    public boolean checkSumInArray(int[] a, int sum) {
        int left = 0;
        int right = a.length - 1;
        int i = 0;

        while (i < a.length) {
            if ((a[left] + a[right]) == sum) {
                return true;
            } else if ((a[right] + a[left]) > sum) {
                right--;
            } else if ((a[right] + a[left]) < sum) {
                left++;
            } else if (a[right] == a[left]) {
                return false;
            }
            i++;
        }
        return false;
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

    public ArrayList<Integer> breakInteger(int a) {
        int iDigit = 0, i = 0;
        ArrayList<Integer> digits = new ArrayList<>();

        while (a != 0) {
            iDigit = a % 10;
            digits.add(iDigit);
            a /= 10; // reduce number
            i++;
        }
        Collections.reverse(digits);

        return digits;
    }// --end of breakInteger

    public ArrayList<Integer> breakIntegerStr(int a) {

        ArrayList<Integer> digits = new ArrayList<>();
        String str = Integer.toString(a);

        for (int i = 0; i < str.length(); i++) {
            digits.add(Character.getNumericValue(str.charAt(i)));
        }

        return digits;

    }// --end of breakIntegerStr

    public boolean isPalindrome(String word) {
        int j = 0, k = word.length() - 1;
        boolean flag = true;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(j) == word.charAt(k)) {
                j++;
                k--;
            } else {
                flag = false;
            }
        }
        return flag;
    }// --end of isPalyndrome

    // Extract numbers from String and return array
    public ArrayList<Integer> extractDigits(String input) {
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digits.add(Character.getNumericValue(input.charAt(i)));
            }
        }
        return digits;
    }

    // Remove duplicates from string
    public String removeStrDuplicates(String input) {
        HashSet<Character> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            if (hs.add(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        return input;
    }

    // Convert integer to string w/out parseInt
    public String intToStr(int input) {
        StringBuilder str = new StringBuilder();

        int mod = 0;
        while (input != 0) {
            mod = input % 10;
            if (mod < 0) {
                mod *= -1;
            }
            str.append(mod);
            input /= 10;
        }

        return str.reverse().toString();
    }

    // Convert string to integer 
    public int strToInt(String str) {
        int answer = 0, factor = 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            answer += (str.charAt(i) - '0') * factor;
            factor *= 10;
        }
        return answer;

    }

    // Reverse words in a sentence e.g. "marco likes chicken" -> "chicken likes marco"
    public String reverseSentence(String input) {
        String[] words = input.split(" ");
        StringBuilder returnStr = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            returnStr.append(words[i] + " ");
        }

        return returnStr.toString();
    }

    // Base coversion
    public String decicmalBaseConversion(String number, int fromBase, int toBase) {
        // Parse the number with source radix  
        // and return in specified radix(base) 
        return Integer.toString(Integer.parseInt(number, fromBase), toBase);
    }

    // Given two integer-valued variables a and b, can you swap without using an additional
    // temporary variable?
    public void swapWithoutTemp(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = b ^ a;
    }

    // Compute all valid IP Addresses
    // Reverse a linked list
    // How would you reverse every other node in a linked list
    // Implement BST
    // Rotate an array from 1|3|4|6|8 rotate by 2: 6|8|1|3|4
    // Implement stack that holds minimum
    // Design Expedia
}
