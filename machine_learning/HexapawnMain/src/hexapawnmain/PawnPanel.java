package hexapawnmain;

import java.awt.Graphics;

/**
 *
 * @author Marco Sep 13, 2018 2:15:46 PM
 */
public class PawnPanel extends javax.swing.JPanel {

    Graphics g;
    String selectedPawn;
    String selectedSquare;

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

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);

        bPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        add(bPawn1);
        bPawn1.setBounds(650, 0, 120, 150);

        bPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        bPawn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bPawn2MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPawn2MouseClicked(evt);
            }
        });
        add(bPawn2);
        bPawn2.setBounds(630, 100, 120, 150);

        bPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        add(bPawn3);
        bPawn3.setBounds(890, 10, 120, 150);

        bPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        add(bPawn4);
        bPawn4.setBounds(790, 10, 120, 150);

        wPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn1);
        wPawn1.setBounds(890, 240, 120, 150);

        wPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn2);
        wPawn2.setBounds(790, 280, 120, 150);

        wPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn3);
        wPawn3.setBounds(870, 150, 120, 150);

        wPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn4);
        wPawn4.setBounds(750, 150, 120, 150);

        A0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        A0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A0MouseClicked(evt);
            }
        });
        add(A0);
        A0.setBounds(10, 0, 155, 160);

        A1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        A1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A1MouseClicked(evt);
            }
        });
        add(A1);
        A1.setBounds(160, 0, 160, 160);

        A2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        A2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A2MouseClicked(evt);
            }
        });
        add(A2);
        A2.setBounds(310, 0, 155, 160);

        A3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        A3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                A3MouseClicked(evt);
            }
        });
        add(A3);
        A3.setBounds(460, 0, 160, 160);

        B0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        B0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B0MouseEntered(evt);
            }
        });
        add(B0);
        B0.setBounds(10, 150, 160, 160);

        B1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B1MouseEntered(evt);
            }
        });
        add(B1);
        B1.setBounds(160, 150, 155, 160);

        B2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        add(B2);
        B2.setBounds(310, 150, 160, 160);

        B3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        add(B3);
        B3.setBounds(460, 150, 155, 160);

        C0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        add(C0);
        C0.setBounds(10, 300, 155, 160);

        C1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        add(C1);
        C1.setBounds(160, 300, 155, 160);

        C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        add(C2);
        C2.setBounds(310, 300, 155, 160);

        C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        add(C3);
        C3.setBounds(460, 300, 160, 160);

        D0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        add(D0);
        D0.setBounds(10, 450, 155, 160);

        D1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        add(D1);
        D1.setBounds(160, 450, 155, 160);

        D2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/grey-square.png"))); // NOI18N
        add(D2);
        D2.setBounds(310, 450, 155, 160);

        D3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-square.png"))); // NOI18N
        add(D3);
        D3.setBounds(460, 450, 155, 160);
    }// </editor-fold>//GEN-END:initComponents

    private void bPawn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn2MouseClicked

    }//GEN-LAST:event_bPawn2MouseClicked

    private void bPawn2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn2MouseReleased

    }//GEN-LAST:event_bPawn2MouseReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void A0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A0MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_A0MouseClicked

    private void A1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_A1MouseClicked

    private void A2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_A2MouseClicked

    private void A3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_A3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_A3MouseClicked

    private void B0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B0MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_B0MouseEntered

    private void B1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_B1MouseEntered


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
