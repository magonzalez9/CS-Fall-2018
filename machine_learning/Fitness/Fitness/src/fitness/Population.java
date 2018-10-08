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

    int numIndividuals;

    Population(int numIndividuals) {
        this.numIndividuals = numIndividuals;
        for (int i = 0; i < numIndividuals; i++) {
            add(new Individual());
        }

    }

    @Override
    public String toString() {
      
        String returnMe = "";
        for (int i = 0; i < size(); i++) {
            returnMe += "\n" + get(i).toString();
        }

        return returnMe;
    }

    public Population getPopulation() {
        return this;
    }

    public void setPopulation(int numIndividuals) {
        this.numIndividuals = numIndividuals;
    }

    void evaluateFitness() {
        System.out.println("evalFitness");
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

        evaluateFitness();
        selectMatingPool();
        applyGeneticOperators();
        replacement();
    }

}
