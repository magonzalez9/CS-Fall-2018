package hexapawnmain;

import javax.swing.ImageIcon;
import java.awt.Graphics;

/**
 *
 * @author Marco Sep 13, 2018 2:15:46 PM
 */
public class PawnPanel extends javax.swing.JPanel {

    Graphics g;
    int x;
    int y;

    public PawnPanel() {
        initComponents();
        setLayout(null);
        setVisible(true);
        
        wPawn4.setVisible(false);
        bPawn4.setVisible(false);
        
        bPawn1.setLocation(15, 308);
        bPawn2.setLocation(170, 308);
        bPawn3.setLocation(325, 308);
        
        wPawn1.setLocation(15, 8);
        wPawn2.setLocation(170, 8);
        wPawn3.setLocation(325, 8);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        if (g == null) {
            return;
        }

        super.paintComponent(g);

        // Draw the car as the user adds them
        ImageIcon board = new ImageIcon(new ImageIcon(getClass().getResource("board.png")).getImage());
       
        // Draw the board
        g.drawImage(board.getImage(), 0, 0, null);       

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

        setLayout(null);

        bPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        add(bPawn1);
        bPawn1.setBounds(540, 20, 120, 150);

        bPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        bPawn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPawn2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bPawn2MouseReleased(evt);
            }
        });
        add(bPawn2);
        bPawn2.setBounds(260, 60, 120, 150);

        bPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        add(bPawn3);
        bPawn3.setBounds(890, 10, 120, 150);

        bPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/black-pawn.png"))); // NOI18N
        add(bPawn4);
        bPawn4.setBounds(700, 50, 120, 150);

        wPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn1);
        wPawn1.setBounds(880, 240, 120, 150);

        wPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn2);
        wPawn2.setBounds(690, 280, 120, 150);

        wPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn3);
        wPawn3.setBounds(830, 180, 120, 150);

        wPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hexapawnmain/white-pawn.png"))); // NOI18N
        add(wPawn4);
        wPawn4.setBounds(760, 310, 120, 150);
    }// </editor-fold>//GEN-END:initComponents

    private void bPawn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn2MouseClicked
        System.out.println("I was pressed at" + evt.getX() +", "  + evt.getY());
    }//GEN-LAST:event_bPawn2MouseClicked

    private void bPawn2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPawn2MouseReleased
         System.out.println("I was pressed at" + evt.getX() +", "  + evt.getY());
    }//GEN-LAST:event_bPawn2MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
