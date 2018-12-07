package dragrace;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class RaceAIList extends ArrayList<RacerAI> {

    public void RaceAIList() {

    }

    public boolean trainingComplete() {
        boolean completionFlag = true;
        for (RacerAI racer : this) {
            if (racer.getStatTotal() < 16) {
                completionFlag = false;
            }
        }
        return completionFlag;
    }

    public String toString() {
        String returnMe = "RaceAIList \n\n";

        for (RacerAI racer : this) {
            returnMe += racer.toString() + "\n\n";
        }

        return returnMe;
    }
}
