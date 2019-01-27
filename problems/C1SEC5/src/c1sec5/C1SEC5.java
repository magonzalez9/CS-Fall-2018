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
public class C1SEC5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Max and min of numeric types
        byte bMax = Byte.MAX_VALUE;
        short sMax = Short.MAX_VALUE;
        int integerMax = Integer.MAX_VALUE;
        float fMax = Float.MAX_VALUE;
        double dMax = Double.MAX_VALUE;
        long lMax = Long.MAX_VALUE;

        // Random methonds
        Random rand = new Random();
        int max = 10;
        int min = 2;
        int d = rand.nextInt(max - min + 1) + min;

        // Box-type static comparing methods
        if (Double.compare(2.3, 2.3) == 0) {
            System.out.println("The numbers match!");
        }

        // Converting 
        char charNumber = '2';
        int a = Character.getNumericValue(charNumber);

        String strNumber = "123";
        int b = Integer.parseInt(strNumber);
      

    }

}
