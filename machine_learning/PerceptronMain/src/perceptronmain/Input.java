/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmain;

/**
 *
 * @author Marco
 */
public class Input {

    // Convert pattern to matrice of numbers. 
    int t;
    int[][] detectors = new int[20][20];

    public Input(Pattern pattern) {
        StringList list = pattern.getList();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                String line = list.get(i);
                char n = line.charAt(j);
                if (n == '-') {
                    detectors[i][j] = 0;
                } else if (n == '*') {
                    detectors[i][j] = 1;
                }
            }
        }

        // Set t value
        t = pattern.getT();
    }

    public int[][] getDetectors() {
        return detectors;
    }

    public int getT() {
        return t;
    }

    @Override
    public String toString() {
        String returnMe = "";

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                returnMe += detectors[i][j] + "";
                if (j == 19) {
                    returnMe += "\n";
                }
            }
        }
        return returnMe;
    }
}
