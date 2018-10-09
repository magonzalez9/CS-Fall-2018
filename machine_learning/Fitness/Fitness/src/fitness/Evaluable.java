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
public interface Evaluable {
    public static final int L=100;  // the length of the chromosome
    
    public byte[] getDNA();
    public int getFitness();
    public void setFitness(int fitness);
    public Evaluable myClone();
    
}
