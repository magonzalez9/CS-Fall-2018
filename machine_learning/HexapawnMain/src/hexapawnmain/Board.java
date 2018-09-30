/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexapawnmain;

import static java.lang.Short.SIZE;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Board implements Cloneable {
    final int X = 1;
    final int O = -1;
    final int EMPTY = 0;
    final int N = 3;

    int[][] sqs;
    int whoseTurn;

    Board() {
        sqs = new int[N][N];
        for (int col = 0; col < N; col++) {
            sqs[0][col] = X;
            sqs[N - 1][col] = O;
        }
    }

    // Clone the current object
    @Override
    public Board clone() {
        Board boardClone = null;

        try {
            boardClone = (Board) super.clone();  // do the shallow copy
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }

        boardClone.sqs = new int[SIZE][SIZE];

        for (int i = 0; i < N; i++) {
            System.arraycopy(sqs[i], 0, boardClone.sqs[i], 0, N);
        }

        return boardClone;
    }

    @Override
    public String toString() {
        String returnMe = "Board\n";

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                returnMe += ("" + ((sqs[row][col] == X) ? "X" : (sqs[row][col] == O) ? "O" : " "));
            }
            returnMe += ("\n");
        }

        return returnMe;
    }

    void modify() {
        sqs[1][1] = X;
        sqs[0][1] = EMPTY;
    }
    
    public void validateMove(int[][] sqsMove){
        Coords from;
        Coords to; 
        
        
        
        
    }
}
