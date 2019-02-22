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

    public boolean checkIfPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] letters = new int[128];
        for (int i = 0; i < a.length(); i++) {
            letters[a.charAt(i)] += 1;
        }

        for (int i = 0; i < b.length(); i++) {
            letters[b.charAt(i)] -= 1;

            if (letters[b.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }// --end of checkIfPermutation

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
        word = word.toLowerCase();
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

    // Implement an algorithm to determine if a string has all unique characters without additional DS
    // KEEP IN MIND lowercase and upper case characters are treated as different charachters!!!
    public boolean checkStringDuplicates(String str) {
        if (str.length() > 128) { // only 128 unique characters exist!
            return false;
        }
        str = str.toLowerCase();
        int currentIndex;
        int lastIndex;

        for (int i = 0; i < str.length(); i++) {
            currentIndex = str.indexOf(str.charAt(i));
            lastIndex = str.lastIndexOf(str.charAt(i));

            if (currentIndex != lastIndex) {
                return false;

            }
        }

        return true;
    }

    // Write a method that replaces all spaces with %20 (or if I am asked to replace something in string)
    public String replaceSpaces(String str) {
        String returnStr;
        int wSpaceCount = 0;
        char[] a = str.toCharArray();

        // Count spaces (or desired character)
        for (Character c : a) {
            if (c == ' ') {
                wSpaceCount++;
            }
        }

        wSpaceCount = (wSpaceCount * 3) - 2; // Size of new array (to add space for new chars '%20')
        char[] b = new char[a.length + wSpaceCount];
        int j = 0;

        for (int i = 0; i < b.length; i++) {
            if (a[j] != ' ') {
                b[i] = a[j];
            } else {
                b[i] = '%';
                b[++i] = '2';
                b[++i] = '0';
            }
            j++;
        }
        returnStr = new String(b);
        return returnStr;
    } // --end of repleaceSpaces()

    // Compress str e.g "aabbcc" => a2b2c2
    public String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            counter++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(counter);
                counter = 0;
            }
        }
        if (compressed.length() < str.length()) {
            return compressed.toString();
        } else {
            return str;
        }
    }
    
    // Check if string is palindrome permutation e.g. 'tact coa' => taco cat
    public boolean checkPalindromePermutation(String str) {
        Hashtable<Character, Integer> ht = new Hashtable();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (ht.containsKey(str.charAt(i))) {
                    ht.put(str.charAt(i), ht.get(str.charAt(i)) + 1);
                } else {
                    ht.put(str.charAt(i), 1);
                }
            }
        }

        int countOdd = 0;

        Set<Character> ks = ht.keySet();

        for (Character key : ks) {
            if ((ht.get(key) % 2) != 0) {
                countOdd++;
            }
        }

        if (countOdd > 1) {
            return false;
        } else {
            return true;
        }
    }
    
    // check the number of edits
    public boolean numEdits(String a, String b) {
        if ((a.length() - b.length()) > 1 || (a.length() - b.length()) < -1) {
            
            return false;
        }

        int j = 0;
        int edits = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(j)) {
                edits++;
                if (edits > 1) {
                    return false;
                }
                if (b.length() > a.length()) {
                    i--;
                    j++;
                }

            } else {
                if (j != b.length() - 1) {
                    j++;
                }

            }
        }

        return true;
    }
    
    // Find the the indices that add up to sum k
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = Integer.valueOf(map.get(target - nums[i]).toString());
                return result;
            }

            map.put(nums[i], i);
        }
        return result;
    }
    
    // Compute all valid IP Addresses
    // Rotate an array from 1|3|4|6|8 rotate by 2: 6|8|1|3|4 (Come back)
    // Implement stack that holds minimum
    // Design Expedia
}
