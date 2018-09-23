/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexapawnmain;

import static java.lang.Short.SIZE;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Board implements Cloneable {

    int pressedRow;
    int pressedCol;
    int left = 30;
    int right = 300;
    int top = 50;
    int pieceWidth = 30;

    final int X = 1;
    final int O = -1;
    final int EMPTY = 0;
    final int N = 3;

    int[][] sqs;
    int whoseTurn;
    private int bottom;

    Hashtable<String, Coords> boardPositions = new Hashtable<>();

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

    public void setBoardPositions() {
        boardPositions.put("A0", new Coords(23, 4));
        boardPositions.put("A1", new Coords(175, 4));
        boardPositions.put("A2", new Coords(327, 4));
        boardPositions.put("A3", new Coords(479, 4));

        boardPositions.put("B0", new Coords(23, 154));
        boardPositions.put("B1", new Coords(175, 154));
        boardPositions.put("B2", new Coords(327, 154));
        boardPositions.put("B3", new Coords(479, 154));

        boardPositions.put("C0", new Coords(23, 304));
        boardPositions.put("C1", new Coords(175, 304));
        boardPositions.put("C2", new Coords(325, 304));
        boardPositions.put("C3", new Coords(475, 304));

        boardPositions.put("D0", new Coords(23, 454));
        boardPositions.put("D1", new Coords(175, 454));
        boardPositions.put("D2", new Coords(325, 454));
        boardPositions.put("D3", new Coords(475, 454));
    }

    void modify() {
        sqs[1][1] = X;
        sqs[0][1] = EMPTY;
    }
}
