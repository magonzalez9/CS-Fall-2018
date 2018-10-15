/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author rachh
 */
public class Population extends java.util.ArrayList<Individual> {

    IndividualList list;
    MatingPool mlist;
    IndividualList childrenList;

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
        mlist = new MatingPool();
        int sum = 0;
        for (Individual i : list) {
            sum += i.getFitness();
            i.runningSum = sum;
        }

        // Update selection rate based on population
        double selectionRate = .2;
        if (numIndividuals > 2500) {
            selectionRate = .1;
        }
        
        for (int i = 0; i < (numIndividuals * .2); i++) {
            int random = Math.abs(r.nextInt() % sum - 1);
            int c = 0;
            while (list.get(c).runningSum < random) {
                c++;
            }

            Individual n = list.get(c).clone();
            mlist.add(n);

        }
    }

    public String getMatingPool() {
        return mlist.toString() + "\nSize: " + mlist.size();
    }

    void applyGeneticOperators(int muRate, int crossPoint) {
        // Apply Mutation
        System.out.println("Before: " + mlist.toString());
        for (int i = 0; i < mlist.size(); i++) {
            for (int j = 0; j < mlist.get(i).getDNA().length; j++) {
                int nextInt = Math.abs(r.nextInt() % (int) muRate);
                if (nextInt == 1) {
//                    System.out.print("YES at index" + j + ",");
                    mlist.get(i).updateBit(j, (byte) mlist.flipBit((int) mlist.get(i).getDNA()[j]));
                }
            }
        }
        System.out.println("\nAFTER: \n " + mlist.toString() + "\n");

        //-- End of Mutation
        // Apply crossover
        // Do the actual crossover
        /*
         ------ = ---***
         ****** = ***---
         Cross over example
         --|--|--   = --**--
         **|**|**   = **--**
        
         -|-|--|-   = -*--*
         *|*|**|*   = *-**-
         */
        ArrayList<Integer> cPoints = new ArrayList<>();
        // Generate x amount of random numbers 
        for (int i = 0; i < crossPoint; i++) {

            int cP = Math.abs((r.nextInt()) % list.get(0).getDNA().length - 1);
            if (!cPoints.contains(cP) && cP != 0 && cP != list.get(0).getDNA().length - 1) {
                cPoints.add(cP);
            } else {
                i--;
            }
        }

        Collections.sort(cPoints);
        Collections.reverseOrder();

        System.out.println("cPoints: " + cPoints.toString());

        // Assuming list is even
        boolean cFlag = true;
        childrenList = new IndividualList();
        for (int i = 0; i < mlist.size() - 1; i += 2) {
            Individual c1 = mlist.get(i).clone();
            Individual c2 = mlist.get(i + 1).clone();

            Individual c1Ref = mlist.get(i).clone();
            Individual c2Ref = mlist.get(i + 1).clone();
            for (int j = 0; j < c1.getDNA().length; j++) {

                if (cPoints.contains(j)) {

                    cFlag = !cFlag;
                }

                if (cFlag == false) {

                    c1.updateBit(j, c2Ref.getDNA()[j]);
                    c2.updateBit(j, c1Ref.getDNA()[j]);
                }

            }
            childrenList.add(c1);
            childrenList.add(c2);

        }

        System.out.println("Theses are the children: " + childrenList.toString());
    }

    void replacement() {
        int start = (list.size() - childrenList.size());

        for (int i = 0; i < childrenList.size(); i++) {
            list.set(start, childrenList.get(i));
            start++;
        }
        Collections.sort(list);

        System.out.println("NEW" + list.toString() + "\n FITNESS:" + evaluateFitness());

    }

    void reset() {
        list = null;
        mlist = null;
        childrenList = null;
    }

    void doageneration(int muRate, int crossPoint) {
        sortList();
        evaluateFitness();
        selectMatingPool();
        applyGeneticOperators(muRate, crossPoint);
        replacement();
    }

}
