/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4main;

import java.util.Random;

/**
 *
 * @author Marco Gonzalez
 */
public class HW4Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testLCS(10000);

    }

    public static void testLCS(int nSize) {
        char[] A = randomArray(nSize);
        char[] B = randomArray(nSize);

        final long startQ = System.nanoTime(); // Start timer
        // Perform quicksort
        LCSlength(A, B);
        final long endQ = System.nanoTime(); // End timer

        System.out.println("Dynamic LCS  Took: " + ((endQ - startQ) / Math.pow(10, 9)) + " seconds for size: " + nSize + " (" + (endQ - startQ) + " nano secs)");

//        final long startH = System.nanoTime(); // Start timer
//        // Perform quicksort
//        LCS(A, B, A.length, B.length);
//        final long endH = System.nanoTime(); // End timer
//
//        System.out.println("Recursive LCS Took: " + ((endH - startH) / Math.pow(10, 9)) + " seconds for size: " + nSize + " (" + (endH - startH) + " nano secs)");

    }

    public static int LCS(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (X[m - 1] == Y[n - 1]) {
            return 1 + LCS(X, Y, m - 1, n - 1);
        } else {
            return Math.max(LCS(X, Y, m, n - 1), LCS(X, Y, m - 1, n));
        }
    }

    public static char[][] LCSlength(char[] X, char[] Y) {
        int m = X.length;
        int n = Y.length;

        char[][] b = new char[m][n];
        int[][] c = new int[m][n];

        for (int i = 1; i < m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X[i] == Y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '<';
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = '^';
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = ' ';
                }
            }
        }
        return b;
    }

    public static void printLCS(char[][] b, char[] X, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (b[i][j] == '<') {
            printLCS(b, X, i - 1, j - 1);
            System.out.println(X[i]);
        } else if (b[i][j] == '^') {
            printLCS(b, X, i - 1, j);
        } else {
            printLCS(b, X, i, j - 1);
        }
    }

    public static char[] randomArray(int size) {

        char[] A = new char[size];

        for (int i = 0; i < A.length; i++) {
            Random rand = new Random();
            // Fill array with random number from 1 to nSize

            if (rand.nextInt(2) == 1) {
                A[i] = '1';
            } else {
                A[i] = '0';
            }
        }

        return A;
    }
}
