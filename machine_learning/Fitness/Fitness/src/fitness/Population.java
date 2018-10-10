/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.util.Collections;

/**
 *
 * @author rachh
 */
public class Population extends java.util.ArrayList<Individual> {

    IndividualList list;
    int numIndividuals;

    Population(int numIndividuals) {
        list = new IndividualList();
        this.numIndividuals = numIndividuals;
        for (int i = 0; i < numIndividuals; i++) {
            list.add(new Individual());
        }

    }

    @Override
    public String toString() {
        return list.toString();
    }

    public IndividualList getPopulationList() {
        return list;
    }

    public void setPopulation(int numIndividuals) {
        this.numIndividuals = numIndividuals;
    }

    public void sortList() {
        Collections.sort(list);
    }

    int evaluateFitness() {
        int avg = 0;
        for (Individual individual : list) {
            avg += individual.getFitness();
        }

        return (avg / numIndividuals);

    }

    void selectMatingPool() {
        System.out.println("selectMatingPool");
    }

    void applyGeneticOperators() {
        System.out.println("applyGeneticOperators");
    }

    void replacement() {
        System.out.println("replacement");
    }

    void doageneration() {
        sortList();
        evaluateFitness();
        selectMatingPool();
        applyGeneticOperators();
        replacement();
    }

}
