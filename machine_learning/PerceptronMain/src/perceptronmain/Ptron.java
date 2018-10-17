package perceptronmain;

/**
 *
 * @author Marco
 */
public class Ptron {

    InputList list;
    StringBuilder output;
    int θ;
    int η;
    int[][] wtsMatrix = new int[20][20];
    boolean errors = true;

    public Ptron(InputList list) {
        this.list = list;
        output = new StringBuilder();

        // Default eta and theta values
        θ = 10000;
        η = 1;
    }

    public void training() {
        // Helper variables to keep track of results
        int correct_count = 0;
        int incorrect_count = 0;
        int counter = 0;
        int numOfIterations = 0;

        while (errors) {
            errors = false;
            for (Input index : list) {
                int[][] trainingPattern = index.getDetectors();

                int DiWi = 0;
                // Get dot product of Di * Wi
                for (int i = 0; i < trainingPattern.length; i++) {
                    for (int j = 0; j < trainingPattern[i].length; j++) {
                        DiWi += trainingPattern[i][j] * wtsMatrix[i][j];
                    }
                }
                // cat categoriztion
                int categoriztion;

                if ((DiWi > θ)) {
                    categoriztion = 1;
                } else {
                    categoriztion = 0;
                }

                // Check if correct
                if (index.getT() != categoriztion) {
                    // INCORRECT
                    incorrect_count++;
                    errors = true;
                    // Learn: wtsMatrix = (T-O) di η
                    for (int i = 0; i < wtsMatrix.length; i++) {
                        for (int j = 0; j < wtsMatrix[i].length; j++) {
                            wtsMatrix[i][j] += (index.getT() - categoriztion) * trainingPattern[i][j] * η;
                        }
                    }

                } else {
                    // CORRECT
                    correct_count++;
                }

                if (counter == list.size() - 1) {
                    numOfIterations++;

                    // Append iteration result to list of results
                    output.append("Correct count: " + correct_count + "\n"
                            + "Incorrect count: " + incorrect_count + "\n\n");

                    // Reset correct/incorrect count for next round of iteration
                    counter = 0;
                    correct_count = 0;
                    incorrect_count = 0;
                } else {
                    counter++;
                }
            }

        } // end of while loop

        // Append total number of iterations to String Builder
        output.append("Total number of iterations: " + numOfIterations);

    } // End of training function

    public void setTheta(int theta) {
        θ = theta;
    }

    public void setEta(int eta) {
        η = eta;
    }

    @Override
    public String toString() {
        return output.toString();
    }

}
