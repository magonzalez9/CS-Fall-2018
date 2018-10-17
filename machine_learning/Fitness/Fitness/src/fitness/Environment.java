/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import Fitnesses.*;

/**
 *
 * @author Marco
 */
public class Environment {

    public static enum Mu { // so we can use these identifiers to select which fitness we are using

        countOnes, mystery, rr
    };

    public static Mu state = Mu.countOnes;  // DEFAULT

    public static Mu getState() {
        return state;
    }

    public static void setState(Mu state) {
        Environment.state = state;
    }

    public static int eval(Evaluable it) {
        switch (state) {
            case countOnes:
                return CountOnes.getValue(it);
            case mystery:
                return Mystery.getValue(it);
            case rr:
                return Fitness4.getValue(it);
            default: {
                //System.out.println("Oops!");
                System.exit(7);
            }
        }
        return -1;
    }

    public static String printFitnessFunctionName() {
        return "Using fitness: " + whichFitness();
    }

    private static String whichFitness() {  // so we can see which fitness the Environment is using
        switch (state) {
            case countOnes:
                return "countOnes";
            case mystery:
                return "mystery";
            case rr:
                return "rr";
            default: {
                //System.out.println("Oops!");
                System.exit(7);
            }
        }
        return "xxx";
    }
}
