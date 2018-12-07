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
public class RacerAI {

    private int speed;
    private int acceleration;
    private int nos;
    private int statTotal;
    private double performanceTime;

    public void RacerAI() {

    }

    void evalPerfomance() {

    }

    void incrementSpeed() {
        if (speed >= 10) {
            if (acceleration < 10) {
                acceleration++;
            } else {
                nos++;
            }
        } else {
            speed++;
        }

    }

    void incrementAcceleration() {
        if (acceleration >= 10) {
            if (nos < 10) {
                nos++;
            } else {
                speed++;
            }
        } else {
            acceleration++;
        }
    }

    void incrementNos() {
        if (nos >= 10) {
            if (speed < 10) {
                speed++;
            } else {
                acceleration++;
            }
        } else {
            nos++;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getNos() {
        return nos;
    }

    public double getPerformanceTime() {
        return performanceTime;
    }

    boolean maxedOut() {
        if ((speed + acceleration + nos) >= 16) {
            return true;
        } else {
            return false;
        }
    }

    int getStatTotal() {
        return speed + acceleration + nos;
    }

    public String toString() {
        return "Speed: " + speed + "\nAcceleration: " + acceleration + "\nNos: " + nos;

    }

}
