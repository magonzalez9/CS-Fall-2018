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
        testSorts(100);
        System.out.println("");
        testSorts(1000);
        System.out.println("");
        testSorts(10000);
        System.out.println("");
        testSorts(100000);
        
    }

    public static void testSorts(int nSize) {
        int[] A = randomArray(nSize);
        int[] B = Arrays.copyOf(A, nSize);

        final long startQ = System.nanoTime(); // Start timer
        // Perform quicksort
        quickSort(A, 0, nSize - 1);
        final long endQ = System.nanoTime(); // End timer

        System.out.println("Quick Sort Took: " + ((endQ - startQ)/Math.pow(10, 9)) + " nano seconds for size: " + nSize + " ("+ (endQ - startQ)+" nano secs)");

        final long startH = System.nanoTime(); // Start timer
        // Perform quicksort
        heapSort(B);
        final long endH = System.nanoTime(); // End timer
        System.out.println("Heap Sort Took: " + ((endH - startH)/ Math.pow(10,9)) + " nano seconds for size: " + nSize+ " ("+ (endH - startH)+" nano secs)");
    }
// -------------Start quick sort ---------------------------------------------

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

// ----------------END quick sort --------------------------------------------
// ----------------Start of HeapSort -----------------------------------------
    public static int[] heapSort(int[] A) {
        A = buildMaxHeap(A);

        for (int i = A.length - 1; i >= 0; i--) {
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;

            heapify(A, i, 0);
        }

        return A;
    }

    public static int[] buildMaxHeap(int[] A) {
        int n = A.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }
        return A;
    }

    public static void heapify(int[] A, int n, int i) {
        int max = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        // left child > root
        if (left < n && (A[left] > A[max])) {
            max = left;
        }
        // right child > max
        if (right < n && A[right] > A[max]) {
            max = right;
        }
        // max is not root
        if (max != i) {
            int tmp = A[i];
            A[i] = A[max];
            A[max] = tmp;

            // heapify affected sub tree
            heapify(A, n, max);
        }

    }

    // ----------------End of HeapSort -----------------------------------------
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
