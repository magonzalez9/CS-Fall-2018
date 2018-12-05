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
public interface Evaluable {
    public static final int L=24;  // the length of the chromosome
    
    public byte[] getDNA();
    public long getFitness();
    public void setFitness(int fitness);
    public Evaluable myClone();
    
}
