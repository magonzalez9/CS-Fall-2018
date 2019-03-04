/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworktwomain;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Marco
 */
public class HomeworkTwoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testQuickSort(100);

    }

    public static void testHeapSort(int nSize) {
        int[] A = randomArray(nSize);
        final long start = System.nanoTime();

        final long end = System.nanoTime();
        System.out.println("Took: " + ((end - start)) + " nano seconds");

    }

    public static void testQuickSort(int nSize) {
        int[] A = randomArray(nSize);
        int[] output;
        final long start = System.nanoTime(); // Start timer
        // Perform quicksort
        output = quickSort(A, 0, nSize - 1);
        final long end = System.nanoTime(); // End timer

        // Print output
        System.out.println(Arrays.toString(output));
        System.out.println("Took: " + ((end - start)) + " nano seconds");

    }

    public static int[] quickSort(int[] A, int low, int high) {

        if (low < high) {
            int pivot = partition(A, low, high);

            quickSort(A, low, pivot - 1);
            quickSort(A, pivot + 1, high);
        }

        return A;
    }

    public static int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (A[j] <= pivot) {
                i++;
                // Swap A[i] with A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        // Swap A[i+1] with A[high] 
        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;
        return (i + 1);
    }

    public static void heapSort() {
        
    }

    public static int[] randomArray(int size) {

        int[] A = new int[size];

        for (int i = 0; i < A.length; i++) {
            Random rand = new Random();
            // Fill array with random number from 1 to nSize
            A[i] = rand.nextInt(size - 1 + 1) + 1;
        }

        return A;
    }

}
