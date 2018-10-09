package Fitnesses;
import fitness.Evaluable;

public class Mystery {

    public static int getValue(Evaluable nextInd) {
        return mystery(nextInd);
    }

    public static int mystery(Evaluable nextInd) {
        boolean bits[] = createBits(nextInd.getDNA());
        double x = getFractionX(bits);
        double y = getFractionY(bits);
        double a = (x - 0.5) * (x - 0.5);
        double b = (y - 0.5) * (y - 0.5);
        //System.out.println("x=" + x + " y=" + y + " a=" + a + " b=" +  b);
        double min = 0.000000001;

        if (a < min) {
            a = min;
        }
        if (b < min) {
            b = min;
        }
        return (int) (1 / a + 1 / b);
    }

    static double getFractionX(boolean[] bits) {
        return getFraction(bits, 0, bits.length / 2);
    }

    static double getFractionY(boolean[] bits) {
        return getFraction(bits, bits.length / 2 + 1, bits.length);
    }

    static double getFraction(boolean[] bits, int start, int stop) {
        double returnMe = 0;
        double currentValue = 0.5;
        for (int i = start; i < stop; i++) {
            if (bits[i]) {
                returnMe += currentValue;
            }
            currentValue /= 2;
        }

        return returnMe;
    }

    private static boolean[] createBits(byte[] dna) {
        boolean[] returnMe = new boolean[Evaluable.L];

        for (int i = 0; i < Evaluable.L; i++) {
            if (dna[i] == 0) {
                returnMe[i] = false;
            } else {
                returnMe[i] = true;
            }
        }

        return returnMe;
    }
}
