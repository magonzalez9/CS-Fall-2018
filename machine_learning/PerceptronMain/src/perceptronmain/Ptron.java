package perceptronmain;

/**
 *
 * @author Marco
 */
public class Ptron {

    InputList list;
    int θ = 10000;
    int η = 1;
    int[][] wtsMatrix = new int[20][20];
    boolean errors = true;

    public Ptron(InputList list) {
        this.list = list;
    }

    public void training() {

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
                int cat;

                if ((DiWi > θ)) {
                    cat = 1;
                } else {
                    cat = 0;
                }

                if (index.getT() != cat) {
                    System.out.println("Incorrect");
                    errors = true;
                    // Learn: wtsMatrix = (T-O) di η
                    for (int i = 0; i < wtsMatrix.length; i++) {
                        for (int j = 0; j < wtsMatrix[i].length; j++) {
                            wtsMatrix[i][j] += (index.getT() - cat) * trainingPattern[i][j] * η;
                        }
                    }

                } else {
                    System.out.println("Correct");
                }
            }

        } // while

        System.out.println("I AM DONE!!!");

    }

}
