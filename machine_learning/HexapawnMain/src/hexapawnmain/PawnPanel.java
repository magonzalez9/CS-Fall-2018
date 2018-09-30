package hexapawnmain;

import java.awt.Graphics;
import java.util.Hashtable;
import javax.swing.JLabel;

/**
 *
 * @author Marco Sep 13, 2018 2:15:46 PM
 */
public class PawnPanel extends javax.swing.JPanel {

    Graphics g;
    String selectedPawn;
    String selectedPawnW;
    String selectedPawnB;
    String selectedSquare;
    JLabel selectedPawnLabel;
    Hashtable<String, JLabel> boardPositions = new Hashtable<>();

    Navigation boardNav = new Navigation();

    public PawnPanel() {
        initComponents();
        setLayout(null);
        setVisible(true);

        // Hide 4x4 Board
        wPawn4.setVisible(false);
        bPawn4.setVisible(false);
        A3.setVisible(false);
        B3.setVisible(false);
        C3.setVisible(false);
        D0.setVisible(false);
        D1.setVisible(false);
        D2.setVisible(false);
        D3.setVisible(false);

        // Set default 3x3 locations
        bPawn1.setLocation(25, 304);
        bPawn2.setLocation(175, 304);
        bPawn3.setLocation(325, 304);
        bPawn4.setLocation(475, 304);
        wPawn1.setLocation(23, 4);
        wPawn2.setLocation(175, 4);
        wPawn3.setLocation(327, 4);
        wPawn4.setLocation(479, 4);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLayout(null);
        setVisible(true);
        setSize(700, 610);
        if (g == null) {
            return;
        }

        super.paintComponent(g);

    }

    void go() {

    }

    void move() {
        if (selectedPawn == null || selectedPawn.equals("")) {
            System.out.println("Please select a pawn and then a board position!");
            selectedPawn = null;
            selectedSquare = null;
            selectedPawnLabel = null;
        } else {
            String pawnKey = boardNav.getPawnPosition(selectedPawn);
            // Set from and to array coordinates
            int fromRow = (int) pawnKey.charAt(0) - 65;
            int fromCol = Integer.parseInt(Character.toString(pawnKey.charAt(1)));

            int toRow = (int) selectedSquare.charAt(0) - 65;
            int toCol = Integer.parseInt(Character.toString(selectedSquare.charAt(1)));

            System.out.println("FROM [" + fromRow + ", " + fromCol + "]");
            System.out.println("TO [" + toRow + ", " + toCol + "]");

            boardNav.updatePawnPos(selectedPawn, selectedSquare);
            selectedPawnLabel.setLocation(boardNav.getBoardPosition(selectedSquare).x, boardNav.getBoardPosition(selectedSquare).y);

            selectedPawn = null;
            selectedSquare = null;
            selectedPawnLabel = null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPawn1 = new javax.swing.JLabel();
        bPawn2 = new javax.swing.JLabel();
        bPawn3 = new javax.swing.JLabel();
        bPawn4 = new javax.swing.JLabel();
        wPawn1 = new javax.swing.JLabel();
        wPawn2 = new javax.swing.JLabel();
        wPawn3 = new javax.swing.JLabel();
        wPawn4 = new javax.swing.JLabel();
        A0 = new javax.swing.JLabel();
        A1 = new javax.swing.JLabel();
        A2 = new javax.swing.JLabel();
        A3 = new javax.swing.JLabel();
        B0 = new javax.swing.JLabel();
        B1 = new javax.swing.JLabel();
        B2 = new javax.swing.JLabel();
        B3 = new javax.swing.JLabel();
        C0 = new javax.swing.JLabel();
        C1 = new javax.swing.JLabel();
        C2 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        D0 = new javax.swing.JLabel();
        D1 = new javax.swing.JLabel();
        D2 = new javax.swing.JLabel();
        D3 = new javax.swing.JLabel();

        setLayout(null);

        bPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        bPawn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bPawn1MousePressed(evt);
            }
        });
        add(bPawn1);
        bPawn1.setBounds(590, -40, 120, 150);

        bPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        bPawn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bPawn2MousePressed(evt);
            }
        });
        add(bPawn2);
        bPawn2.setBounds(630, 100, 120, 150);

        bPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        bPawn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bPawn3MousePressed(evt);
            }
        });
        add(bPawn3);
        bPawn3.setBounds(890, 10, 120, 150);

        bPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        bPawn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bPawn4MousePressed(evt);
            }
        });
        add(bPawn4);
        bPawn4.setBounds(790, 10, 120, 150);

        wPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        wPawn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                wPawn1MousePressed(evt);
            }
        });
        add(wPawn1);
        wPawn1.setBounds(890, 240, 120, 150);

        wPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        wPawn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                wPawn2MousePressed(evt);
            }
        });
        add(wPawn2);
        wPawn2.setBounds(790, 280, 120, 150);

        wPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        wPawn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                wPawn3MousePressed(evt);
            }
        });
        add(wPawn3);
        wPawn3.setBounds(870, 150, 120, 150);

        wPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        wPawn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                wPawn4MousePressed(evt);
            }
        });
        add(wPawn4);
        wPawn4.setBounds(750, 150, 120, 150);

        A0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        A0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                A0MousePressed(evt);
            }
        });
        add(A0);
        A0.setBounds(10, 0, 155, 160);

        A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        A1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                A1MousePressed(evt);
            }
        });
        add(A1);
        A1.setBounds(160, 0, 160, 160);

        A2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        A2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                A2MousePressed(evt);
            }
        });
        add(A2);
        A2.setBounds(310, 0, 155, 160);

        A3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        A3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                A3MousePressed(evt);
            }
        });
        add(A3);
        A3.setBounds(460, 0, 160, 160);

        B0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        B0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B0MousePressed(evt);
            }
        });
        add(B0);
        B0.setBounds(10, 150, 160, 160);

        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B1MousePressed(evt);
            }
        });
        add(B1);
        B1.setBounds(160, 150, 155, 160);

        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B2MousePressed(evt);
            }
        });
        add(B2);
        B2.setBounds(310, 150, 160, 160);

        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                B3MousePressed(evt);
            }
        });
        add(B3);
        B3.setBounds(460, 150, 155, 160);

        C0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        C0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                C0MousePressed(evt);
            }
        });
        add(C0);
        C0.setBounds(10, 300, 155, 160);

        C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        C1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                C1MousePressed(evt);
            }
        });
        add(C1);
        C1.setBounds(160, 300, 155, 160);

        C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        C2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                C2MousePressed(evt);
            }
        });
        add(C2);
        C2.setBounds(310, 300, 155, 160);

        C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        C3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                C3MousePressed(evt);
            }
        });
        add(C3);
        C3.setBounds(460, 300, 160, 160);

        D0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        D0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                D0MousePressed(evt);
            }
        });
        add(D0);
        D0.setBounds(10, 450, 155, 160);

        D1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        D1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                D1MousePressed(evt);
            }
        });
        add(D1);
        D1.setBounds(160, 450, 155, 160);

        D2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        D2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                D2MousePressed(evt);
            }
        });
        add(D2);
        D2.setBounds(310, 450, 155, 160);

        D3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        D3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                D3MousePressed(evt);
            }
        });
        add(D3);
        D3.setBounds(460, 450, 155, 160);
    }// </editor-fold>//GEN-END:initComponents

    private void bPawn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn1MousePressed
        selectedPawn = "bPawn1";
        selectedPawnLabel = bPawn1;
    }//GEN-LAST:event_bPawn1MousePressed

    private void bPawn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn2MousePressed
        selectedPawn = "bPawn2";
        selectedPawnLabel = bPawn2;
    }//GEN-LAST:event_bPawn2MousePressed

    private void bPawn3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn3MousePressed
        selectedPawn = "bPawn3";
        selectedPawnLabel = bPawn3;
    }//GEN-LAST:event_bPawn3MousePressed

    private void bPawn4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn4MousePressed
        selectedPawn = "bPawn4";
        selectedPawnLabel = bPawn4;
    }//GEN-LAST:event_bPawn4MousePressed

    private void wPawn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wPawn1MousePressed
        selectedPawn = "wPawn1";
        selectedPawnLabel = wPawn1;
    }//GEN-LAST:event_wPawn1MousePressed

    private void wPawn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wPawn2MousePressed
        selectedPawn = "wPawn2";
        selectedPawnLabel = wPawn2;
    }//GEN-LAST:event_wPawn2MousePressed

    private void wPawn3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wPawn3MousePressed
        selectedPawn = "wPawn3";
        selectedPawnLabel = wPawn3;
    }//GEN-LAST:event_wPawn3MousePressed

    private void wPawn4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wPawn4MousePressed
        selectedPawn = "wPawn4";
        selectedPawnLabel = wPawn4;
    }//GEN-LAST:event_wPawn4MousePressed

    private void A0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A0MousePressed
        selectedSquare = "A0";
        move();
    }//GEN-LAST:event_A0MousePressed

    private void A1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A1MousePressed
        selectedSquare = "A1";
        move();
    }//GEN-LAST:event_A1MousePressed

    private void A2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A2MousePressed
        selectedSquare = "A2";
        move();
    }//GEN-LAST:event_A2MousePressed

    private void A3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A3MousePressed
        selectedSquare = "A2";
        move();
    }//GEN-LAST:event_A3MousePressed

    private void B0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B0MousePressed
        selectedSquare = "B0";
        move();
    }//GEN-LAST:event_B0MousePressed

    private void B1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MousePressed
        selectedSquare = "B1";
        move();
    }//GEN-LAST:event_B1MousePressed

    private void B2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MousePressed
        selectedSquare = "B2";
        move();
    }//GEN-LAST:event_B2MousePressed

    private void B3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MousePressed
        selectedSquare = "B3";
        move();
    }//GEN-LAST:event_B3MousePressed

    private void C0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C0MousePressed
        selectedSquare = "C0";
        move();
    }//GEN-LAST:event_C0MousePressed

    private void C1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C1MousePressed
        selectedSquare = "C1";
        move();
    }//GEN-LAST:event_C1MousePressed

    private void C2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C2MousePressed
        selectedSquare = "C2";
        move();
    }//GEN-LAST:event_C2MousePressed

    private void C3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C3MousePressed
        selectedSquare = "C3";
        move();
    }//GEN-LAST:event_C3MousePressed

    private void D0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D0MousePressed
        selectedSquare = "D0";
        move();
    }//GEN-LAST:event_D0MousePressed

    private void D1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D1MousePressed
        selectedSquare = "D1";
        move();
    }//GEN-LAST:event_D1MousePressed

    private void D2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D2MousePressed
        selectedSquare = "D2";
        move();
    }//GEN-LAST:event_D2MousePressed

    private void D3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D3MousePressed
        selectedSquare = "D3";
        move();
    }//GEN-LAST:event_D3MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A0;
    private javax.swing.JLabel A1;
    private javax.swing.JLabel A2;
    private javax.swing.JLabel A3;
    private javax.swing.JLabel B0;
    private javax.swing.JLabel B1;
    private javax.swing.JLabel B2;
    private javax.swing.JLabel B3;
    private javax.swing.JLabel C0;
    private javax.swing.JLabel C1;
    private javax.swing.JLabel C2;
    private javax.swing.JLabel C3;
    private javax.swing.JLabel D0;
    private javax.swing.JLabel D1;
    private javax.swing.JLabel D2;
    private javax.swing.JLabel D3;
    private javax.swing.JLabel bPawn1;
    private javax.swing.JLabel bPawn2;
    private javax.swing.JLabel bPawn3;
    private javax.swing.JLabel bPawn4;
    private javax.swing.JLabel wPawn1;
    private javax.swing.JLabel wPawn2;
    private javax.swing.JLabel wPawn3;
    private javax.swing.JLabel wPawn4;
    // End of variables declaration//GEN-END:variables

}
