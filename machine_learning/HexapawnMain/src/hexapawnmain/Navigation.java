/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexapawnmain;

import java.util.Hashtable;

/**
 *
 * @author Marco Gonzalez
 */
public class Navigation {

    public Navigation() {
        setBoardPositions();
        setInitialPawnPositions();
    }

    Hashtable<String, Coords> boardPositions = new Hashtable<>();
    Hashtable<String, String> pawnPositions = new Hashtable<>();

    public final void setBoardPositions() {
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

    public final void setInitialPawnPositions() {
        pawnPositions.put("wPawn1", "A0");
        pawnPositions.put("wPawn2", "A1");
        pawnPositions.put("wPawn3", "A2");
        pawnPositions.put("wPawn4", "A3");

        pawnPositions.put("bPawn1", "C0");
        pawnPositions.put("bPawn2", "C1");
        pawnPositions.put("bPawn3", "C2");
        pawnPositions.put("bPawn4", "D3");
    }

    public void updatePawnPos(String pawn, String boardKey) {
        //pawnPositions.put(pawn, boardKey);
        pawnPositions.replace(pawn, boardKey);
        
    }

    // Function getPawnPosition
    // Params: key - e.g 'bPawn1' will return location key (e.g. 'A0') of where that pawn is located
    public String getPawnPosition(String key) {
        return pawnPositions.get(key);
    }

    // Function getPawnPosition
    // Params: key - e.g 'A0' will return the coordinates of the board square
    public Coords getBoardPosition(String key) {
        return boardPositions.get(key);
    }
}
