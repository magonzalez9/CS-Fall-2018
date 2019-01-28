/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1sec5;

import java.util.*;

/**
 *
 * @author Marco
 */
public class Primitive {

    // A 64 bit integer can be viewed as an array of 64 bits, with the bit at
    // index 0 corresponding to the least significant bit, and the bit at index 
    // 63 corresponding to the most significant bit. Implement code that takes as 
    // input a 64-bit integer X and swaps the bits at indices i and j. 
    public long getInteger(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }

    // Given two integer-valued variables a and b, can you swap without using an additional
    // temporary variable?
    public void swapWithoutTemp(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = b ^ a;
    }

    // How would you compute the parity of a very large number of 64 words?
    public short computeParity(long x) {
        short result = 0;

        while (x != 0) {
            result ^= 1;
            x &= (x - 1); // erases lowest set bit
        }

        return result;
    }

    public void isolateNumbers(int number) {
        int ithInt;
        while (number > 0) {
            ithInt = number % 10;
            number = number / 10;
        }
    }

    public String decicmalBaseConversion(String number,int fromBase, int toBase) {
        // Parse the number with source radix  
        // and return in specified radix(base) 
        return Integer.toString(Integer.parseInt(number, fromBase), toBase);
    }
}
