
package Fitnesses;
import fitness.Evaluable;

/**
 *
 * @author Marco
 */
public class CountOnes {

    public static int getValue(Evaluable nextInd) {
        int count = 0;

        for (byte nextByte : nextInd.getDNA()) {
            if (nextByte == 1) {
                count++;
            }
        }

        return count;
    }
}
