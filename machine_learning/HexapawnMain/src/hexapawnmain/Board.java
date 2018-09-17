/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexapawnmain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static java.lang.Short.SIZE;
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

    void paint(Graphics g) {
        setConstants(g);
        drawBoard(g);
        drawPieces(g);
    }

    private void drawBoard(Graphics g) {
        vert(g);
        horiz(g);
    }

    private void drawPieces(Graphics g) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (sqs[row][col] != EMPTY) {
                    drawPiece(g, row, col);
                }
            }
        }
    }

    private void vert(Graphics g) {
        for (int i = 0; i < 4; i++) {
            g.drawLine(left + i * pieceWidth, top, left + i * pieceWidth, bottom);
        }
    }

    private void horiz(Graphics g) {
        for (int i = 0; i < 4; i++) {
            g.drawLine(left, top + i * pieceWidth, right, top + i * pieceWidth);
        }
    }

    private void drawPiece(Graphics g, int row, int col) {
        if (sqs[row][col] != X) {
            g.setColor(Color.red);
        }
        g.fillOval(left + col * pieceWidth + 1, top + row * pieceWidth + 1, pieceWidth - 2, pieceWidth - 2);
    }

    void handlePressed(int x, int y) {
        pressedRow = (y - top) / pieceWidth;
        pressedCol = (x - left) / pieceWidth;
        System.out.println("col = " + pressedCol);
        System.out.println("row = " + pressedRow);
    }

    private void setConstants(Graphics g) {
        Rectangle r = g.getClipBounds();

        g.drawRect(r.x + 2, r.y + 2, r.width - 4, r.height - 4);
        left = 30;
        right = r.width - 20;
        top = 15;
        pieceWidth = (right - left) / N;
        bottom = top + pieceWidth * N;
    }

    void modify() {
        sqs[1][1] = X;
        sqs[0][1] = EMPTY;
    }
}
