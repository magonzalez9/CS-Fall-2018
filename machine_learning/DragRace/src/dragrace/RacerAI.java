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
    private double performanceTime;

    public void RacerAI() {

    }

    void evalPerfomance() {

    }

    void incrementSpeed() {
        this.speed++;
    }

    void incrementAcceleration() {
        this.acceleration++;
    }

    void incrementNos() {
        this.nos++;
    }

    int getStatTotal() {
        return this.speed + this.acceleration + this.nos;
    }

}
