package hexapawnmain;

import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco Sep 13, 2018 2:15:46 PM
 */
public class PawnPanel extends javax.swing.JPanel {

    Graphics g;

    public PawnPanel() {
        initComponents();
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        g.fillOval(100, 100, 100, 100);            // Just checking!
        if (g == null) {
            return;
        }

        super.paintComponent(g);

        // Draw the car as the user adds them
        ImageIcon pawn1 = new ImageIcon(new ImageIcon(getClass().getResource("board.png")).getImage());
        g.drawImage(pawn1.getImage(), 0, 0, null);

    }

    void go() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
