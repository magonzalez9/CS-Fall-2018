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
        int[] a = {1, 3, 5, 5, 7, 9, 20, 20, 90};
        int[] b = {20, 25, 30, 50};
        int[] result = problem.mergeSorted(a, b);
        System.out.println("Merge sorted: " + Arrays.toString(result));

        // Sort arrays EVEN -> ODD
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evenSort = problem.sortEvenOdd(c);
        System.out.println(Arrays.toString(evenSort));

        // Check if sum EXISTS in array
        int[] d = {2, 3, 5, 8, 10, 12, 14, 14, 16, 20};
        boolean sumResult = problem.checkSumInArray(d, 24);
        System.out.println("Sum exists in sorted array: " + sumResult);

        // Check if Permutation
        boolean permResult = problem.checkIfPermutation("cheep", "cheap");
        System.out.println("Permutation Result: " + permResult);

        // Break Integer 
        ArrayList<Integer> digits = problem.breakInteger(1234);
        System.out.println("Break Integer" + digits.toString());

        // Break integer String method
        ArrayList<Integer> digitsOfstr = problem.breakIntegerStr(1234);
        System.out.println(digitsOfstr.toString());

        // Check if is palindrome
        boolean pResult = problem.isPalindrome("poop");
        System.out.println("Palyndrome result " + pResult);

        // Get digits from str
        ArrayList<Integer> numbers = problem.extractDigits("str3546fdf1");
        System.out.println(numbers.toString());

        // Remove duplicates form str
        System.out.println(problem.removeStrDuplicates("Ffuucckk"));

        // Integer to string converstion
        System.out.println(problem.intToStr(-1234));

        // String to integer conversion
        System.out.println(problem.strToInt("1234"));

        // Reveres sentence
        System.out.println(problem.reverseSentence("Marco likes chicken"));

        // Check duplicates no data structures
        System.out.println("Duplicates no DS: " + problem.checkStringDuplicates("Marcooo"));

        // Replace Spaces
        System.out.println(problem.replaceSpaces("Marco is cool"));

        System.out.println(problem.compress("aaabbcccd"));

        System.out.println("Palindrome/Permutations Result: " + problem.checkPalindromePermutation("cop coa"));

        System.out.println("Edits result: " + problem.numEdits("pale", "bale"));

        int[] two = {1, 2, 3, 4, 5, 5, 7, 8, 9, 10};
        System.out.println("Two sum " + Arrays.toString(problem.twoSum(two, 122)));
    }

}
