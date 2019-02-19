/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmaxsubarray;

import java.util.Arrays;

/**
 *
 * @author Marco
 */
public class FindMaxSubArray {

    public static final int LEFT_LOW = 0;
    public static final int LEFT_HIGH = 1;
    public static final int LEFT_SUM = 2;

    public static final int RIGHT_LOW = 0;
    public static final int RGHT_HIGH = 1;
    public static final int RIGHT_SUM = 2;

    public static final int CROSS_LOW = 0;
    public static final int CROSS_HIGH = 1;
    public static final int CROSS_SUM = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] values = {2, -3, 5, 2, 1,-1, -3, -1, 20, 90};
        int[] maxSubArr = findMaxSubArray(values, 0, (values.length - 1));
        System.out.println(Arrays.toString(maxSubArr));

    }

    public static int[] findMaxSubArray(int[] A, int low, int high) {
        if (high == low) {
            return A;
        } else {
            int mid = (low + high) / 2;
            int[] left = findMaxSubArray(A, low, mid);
            int[] right = findMaxSubArray(A, mid + 1, high);
            int[] cross = findMaxCrossingSubArray(A, low, mid, high);

            if (left[LEFT_SUM] >= right[RIGHT_SUM] && left[LEFT_SUM] >= cross[CROSS_SUM]) {
                return left;
            } else if (right[RIGHT_SUM] >= left[LEFT_SUM] && right[RIGHT_SUM] >= cross[CROSS_SUM]) {
                return right;
            } else {
                return cross;
            }
        }

    }

    public static int[] findMaxCrossingSubArray(int[] A, int low, int mid, int high) {
        int left_sum = (Integer.MAX_VALUE) * -1;

        int sum = 0;
        int right_sum = 0;
        int max_right = 0;
        int max_left = 0;

        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        System.out.println(left_sum);
        right_sum = (Integer.MAX_VALUE) * -1;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + A[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }

        int[] B = {max_left, max_right, (left_sum + right_sum)};

        return B;
    }

}
