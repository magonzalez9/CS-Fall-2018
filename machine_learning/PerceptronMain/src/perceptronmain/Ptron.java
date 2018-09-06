package perceptronmain;

/**
 *
 * @author Marco
 */
public class Ptron {

    InputList list;
    int θ;
    int η;
    int[][] wtsMatrix = new int[20][20];

    public Ptron(InputList list) {
        this.list = list;
    }

    public void training() {
        boolean errors = false;

        while (errors) {
            errors = false;
            for (Input index : list) {
                int[][] trainingPattern = index.getDetectors();

                int DiWi = 0;
                // Get sum of matrix
                for (int i = 0; i < trainingPattern.length; i++) {
                    for (int j = 0; j < trainingPattern[i].length; j++) {
                        DiWi += trainingPattern[i][j];
                    }
                }

                if (!(DiWi > θ)) {
                    errors = true;
                    // Learn
                    // Δwi = (T-O) di η 
                }
            }

        } // while

    }

}
