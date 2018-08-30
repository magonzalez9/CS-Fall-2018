/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Marco
 */
public class FileFrame extends javax.swing.JFrame {

    String currentFilePath = "";

    public FileFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(240, 60, 80, 30);

        jButton2.setText("Select File...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 60, 120, 30);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 100, 310, 140);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("File Program");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, -10, 170, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // FileChooser object definition and StringBuilder creation
        JFileChooser fileChooser = new JFileChooser();
        StringBuilder fileContents = new StringBuilder();

        // Prompt user to select file
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            textArea.setText("You chose to open this file: "
                    + fileChooser.getSelectedFile().getName());
        }

        java.io.File file = fileChooser.getSelectedFile();
        currentFilePath = file.getAbsolutePath();

        try {
            BufferedReader in;
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                fileContents.append(line);
                line = in.readLine();

            }

            textArea.setText(fileContents.toString());
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        String str = textArea.getText();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(currentFilePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] strToBytes = str.getBytes();
        try {
            outputStream.write(strToBytes);
        } catch (IOException ex) {
            Logger.getLogger(FileFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
