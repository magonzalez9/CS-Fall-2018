
package Fitnesses;
import fitness.Comparable;

/**
 *
 * @author Marco
 */
public class CountOnes {

    public static int getValue(Comparable nextInd) {
        int count = 0;

        for (byte nextByte : nextInd.getDNA()) {
            if (nextByte == 1) {
                count++;
            }
        }

        return count;
    }
}
