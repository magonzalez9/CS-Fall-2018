/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

/**
 *
 * @author rachh
 */
public class Population extends java.util.ArrayList<Individual> {

    int numIndividuals;
    Individual[] pop;

    Population(int n) {
        numIndividuals = n;
        pop = new Individual[n];
        for (int i = 0; i < n; i++) {
            //this.add(new Individual());
            pop[i] = new Individual();
        }
    }

    @Override
    public String toString() {
        String returnMe = "";
        for (int i = 0; i < pop.length; i++) {
            returnMe += "\n" + pop[i].toString();
        }
        return returnMe;
    }

    public Individual[] getPopulation() {
        return pop;
    }

    public void setPopulation(Individual[] population) {
        pop = population;
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
