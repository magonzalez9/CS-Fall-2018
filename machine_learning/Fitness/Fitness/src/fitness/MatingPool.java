/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class MatingPool extends ArrayList<Individual> {

    @Override
    public String toString() {
        String returnMe = "Mating Pool";

        for (Individual nextInd : this) {
            returnMe += "\n\t" + nextInd.toString();
        }

        return returnMe;
    }

    public int flipBit(int i) {
        if (i == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
