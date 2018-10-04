/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

/**
 *
 * @author Marco
 */
public class TestMu {

    public static void main(String[] args) {
        Environment.setState(Environment.Mu.countOnes);

        System.out.println(Environment.printFitnessFunctionName());
        Environment.setState(Environment.Mu.mystery);
        System.out.println(Environment.printFitnessFunctionName());
        Environment.setState(Environment.Mu.rr);
        System.out.println(Environment.printFitnessFunctionName());
    }
}
