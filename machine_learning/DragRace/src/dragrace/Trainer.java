/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragrace;

/**
 *
 * @author Marco
 */
public class Trainer {

    Population pList;
    RaceAIList rList;

    int population;
    int crossover;
    int muRate;

    public Trainer(int population, int crossover, double muRate) {
        pList = new Population(population);
        rList = new RaceAIList();

        this.population = population;
        this.crossover = crossover;
        this.muRate = (int) (1 / muRate);
    }

    public void train() {
        IndividualList indvidualList = pList.getPopulationList();
        
        for (int i = 0; i < indvidualList.size(); i++) {
            if (rList.isEmpty()) {
                
            }
        }
        pList.doageneration(muRate, crossover);
        System.out.println(pList.toString() + "\nFitness avg:" + pList.evaluateFitness());

        for (int i = 0; i < pList.getPopulationList().size(); i++) {
            System.out.println("Speed: " + pList.getPopulationList().get(i).getSpeedStat());
            System.out.println("Acceleration: " + pList.getPopulationList().get(i).getAccStat());
            System.out.println("NOS: " + pList.getPopulationList().get(i).getNosStat());
            System.out.println(" ");
        }

        pList.doageneration(muRate, crossover);
        System.out.println(pList.toString() + "\nFitness avg:" + pList.evaluateFitness());
        System.out.println("NEW");
        for (int i = 0; i < pList.getPopulationList().size(); i++) {
            System.out.println("Speed: " + pList.getPopulationList().get(i).getSpeedStat());
            System.out.println("Acceleration: " + pList.getPopulationList().get(i).getAccStat());
            System.out.println("NOS: " + pList.getPopulationList().get(i).getNosStat());
            System.out.println(" ");
        }
    }

}
