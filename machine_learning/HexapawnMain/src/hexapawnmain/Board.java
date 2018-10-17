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
    int whoseTurn = O;

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

    public int getWhoseTurn() {
        return whoseTurn;
    }

    public void setWhoseTurn(int whoseTurn) {
        this.whoseTurn = whoseTurn;
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

    void modify(int fromRow, int fromCol, int toRow, int toCol, int who) {
        sqs[toRow][toCol] = who;
        sqs[fromRow][fromCol] = EMPTY;
    }

    public boolean validateMove(int fromRow, int fromCol, int toRow, int toCol) {
        boolean flag = false;

        //System.out.println("FROM [" + fromRow + ", " + fromCol + "]");
        //System.out.println("TO [" + toRow + ", " + toCol + "]");

        //System.out.println("X: " + (fromRow + 1) + " == " + toRow);
        //System.out.println("O: " + (fromRow - 1) + " == " + toRow);
        if (whoseTurn == X && sqs[fromRow][fromCol] == X) {
            //System.out.println("YES");

            if ((fromRow + 1) == toRow && fromCol == toCol) {
                flag = true;
                modify(fromRow, fromCol, toRow, toCol, X);
                setWhoseTurn(O);
            }
        } else if (whoseTurn == O && sqs[fromRow][fromCol] == O) {
            //System.out.println("YES");

            if ((fromRow - 1) == toRow && fromCol == toCol) {
                flag = true;
                modify(fromRow, fromCol, toRow, toCol, O);
                setWhoseTurn(X);
            }
        }

        return flag;
    }

    public boolean validateTake(int bRow, int bCol, int wRow, int wCol) {
        boolean flag = false;
        if (getWhoseTurn() == X){
            
        }
        return flag;
    }
}
