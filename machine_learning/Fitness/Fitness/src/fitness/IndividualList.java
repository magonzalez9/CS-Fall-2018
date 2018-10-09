/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.util.ArrayList;

/**
 *
 * @author Marco Gonzalez
 */
public class IndividualList extends ArrayList<Individual> {

    @Override
    public String toString() {
        String returnMe = "IndividualList";

        for (Individual nextInd : this) {
            returnMe += "\n\t" + nextInd.toString();
        }

        return returnMe;
    }
}
