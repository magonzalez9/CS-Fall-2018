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
public class RacerAI implements Comparable<RacerAI> {

    private int speed;
    private int acceleration;
    private int nos;
    private int statTotal;
    public double performanceTime;

    public void RacerAI() {

    }

    public void incrementPerformanceTime() {
        performanceTime++;
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

    public void resetTime() {
        performanceTime = 0;
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

    @Override
    public int compareTo(RacerAI t) {
        if (this.performanceTime < t.performanceTime) {
            return -1;
        } else if (t.performanceTime < this.performanceTime) {
            return 1;
        }
        return 0;
    }
    
    public String toString() {
        return "Speed: " + speed + "\nAcceleration: " + acceleration + "\nNos: " + nos + "\nPerformance Time: " + performanceTime;

    }

}
