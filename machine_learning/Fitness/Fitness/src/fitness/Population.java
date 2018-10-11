/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.util.Collections;
import java.util.Random;

/**
 *
 * @author rachh
 */
public class Population extends java.util.ArrayList<Individual> {

    IndividualList list;
    int numIndividuals;
    Random r = new Random();

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
//        given a list of individuals; each with variables for fitness and runningSum 
//	sum=0;
//	for each individual {
//		sum += fitness
//		currentIndividual.runningSum = sum
//	}
//
//	iterate p times (p is the number of individuals in the mating pool) {
//		r = random number between 0 and sum-1 (inclusive)
//		start with first individual in the mating pool list
//		while currentIndividual.runningSum < r
//			go to next individual
//		add clone of current individual to mating pool
//	}
        int sum = 0;
        for (Individual i : list) {
            sum += i.getFitness();
            i.runningSum = sum;
        }

        for (int i = 0; i < (numIndividuals * .2); i++) {
            int random = Math.abs(r.nextInt() % sum-1);
            list.get(0);

        }

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
