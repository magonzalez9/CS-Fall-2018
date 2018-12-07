/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Individual implements Cloneable, Evaluable, Comparable<Individual> {

    long fitness;
    byte[] dna;
    int runningSum;

    public Individual() {
        dna = new byte[L];
        init();
    }

    @Override
    public Individual clone() {
        Individual individualClone = null;

        try {
            individualClone = (Individual) super.clone();  // do the shallow copy
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Individual.class.getName()).log(Level.SEVERE, null, ex);
        }

        individualClone.dna = new byte[L];
        for (int i = 0; i < L; i++) {
            individualClone.dna[i] = dna[i];

        }
        return individualClone;
    }

    void init() {
        for (int i = 0; i < L; i++) {
            dna[i] = (byte) (Util.rand(2) & 0xFF);
        }
        // so it has a fitness to start off
        fitness = Environment.eval(this);

    }

    @Override
    public byte[] getDNA() {
        return dna;
    }

    @Override
    public long getFitness() {
        return fitness;
    }

    @Override
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public Evaluable myClone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo(Individual individual) {
        if (this.fitness == individual.fitness) {
            return 0;
        }
        if (this.fitness < individual.fitness) {
            return 1;
        }
        return -1;
    }

    public void updateBit(int index, byte value) {
        dna[index] = value;
        fitness = Environment.eval(this);
    }

    public int getSpeedStat() {
        int bit = 128;
        int speed = 0;
        for (int i = 0; i <= 7; i++) {
            if (dna[i] == 1) {
                speed += bit;
            }
            bit -= (bit / 2);
        }
        return speed;

    }

    public int getAccStat() {
        int bit = 128;
        int acc = 0;
        for (int i = 8; i <= 15; i++) {
            if (dna[i] == 1) {
                acc += bit;
            }
            bit -= (bit / 2);
        }
        return acc;
    }

    public int getNosStat() {
        int bit = 128;
        int nos = 0;
        for (int i = 16; i <= 23; i++) {
            if (dna[i] == 1) {
                nos += bit;
            }
            bit -= (bit / 2);
        }
        return nos;

    }

    public String getMaxStat() {
        int[] stats = new int[]{getSpeedStat(), getAccStat(), getNosStat()};
        Arrays.sort(stats);

        if (getSpeedStat() == stats[2]) {
            return "speed";
        } else if (getAccStat() == stats[2]) {
            return "acceleration";
        } else {
            return "nos";
        }

    }

    public String printIndividualStats() {
        return "Speed: " + getSpeedStat() + "\n"
                + "Acceleration: " + getAccStat() + "\n"
                + "Nos: " + getNosStat();
    }

    private String format(byte[] dna) { // make the byte[] into a String
        String returnMe = "";

        for (byte nextByte : dna) {
            returnMe += nextByte;
        }

        return returnMe;
    }

    @Override
    public String toString() {
        return "Ind: " + Environment.printFitnessFunctionName()
                + " fitness=" + fitness + ", dna=" + format(dna);
    }
}
