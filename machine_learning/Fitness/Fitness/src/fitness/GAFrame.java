/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

/**
 *
 * @author Marco
 */
public class GAFrame extends javax.swing.JFrame {

    /**
     * Creates new form GAFrame
     */
    Population pList;

    public GAFrame() {
        initComponents();

        // Population slider defaults
        pField.setText("10");
        muField.setText(".001");
        crossField.setText("1");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        run = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pField = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        populationLabel = new javax.swing.JLabel();
        crossField = new javax.swing.JTextField();
        muField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        run.setText("RUN");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });
        getContentPane().add(run);
        run.setBounds(1010, 230, 170, 40);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 280, 1170, 310);

        jLabel1.setText("Mutation Rate");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 160, 100, 20);

        jLabel2.setText("Population Size");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 120, 30);

        jLabel3.setText("Crossover");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 220, 70, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Genetic Algorithm Program");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 10, 550, 50);

        pField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFieldActionPerformed(evt);
            }
        });
        getContentPane().add(pField);
        pField.setBounds(20, 120, 100, 30);

        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(830, 230, 170, 40);
        getContentPane().add(populationLabel);
        populationLabel.setBounds(200, 130, 0, 0);
        getContentPane().add(crossField);
        crossField.setBounds(20, 240, 100, 30);
        getContentPane().add(muField);
        muField.setBounds(20, 180, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        // TODO add your handling code here:
        int population = Integer.parseInt(pField.getText());
        int crossover = Integer.parseInt(crossField.getText());
        double muRate = Double.parseDouble(muField.getText());

        pList = new Population(population);
        pList.doageneration();

        textArea.setText(pList.toString() + "\nFitness avg:" + pList.evaluateFitness());
    }//GEN-LAST:event_runActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void pFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GAFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField crossField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField muField;
    private javax.swing.JTextField pField;
    private javax.swing.JLabel populationLabel;
    private javax.swing.JButton reset;
    private javax.swing.JButton run;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
