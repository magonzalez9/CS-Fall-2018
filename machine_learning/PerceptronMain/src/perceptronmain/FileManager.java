/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Marco
 */
public class FileManager {

    public File selectFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Perceptron");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File file = null;
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }

        return file;
    }

    public BufferedReader getFileContent(File file) throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }

    public void updateFile(String filePath, String updateString) {

        if (filePath == null || filePath == "") {
            System.out.println("PLEASE SELECT A FILE!");
        } else {
            File fileToUpdate = new File(filePath);

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(filePath);
            } catch (FileNotFoundException ex) {

            }
            byte[] strToBytes = updateString.getBytes();
            try {
                outputStream.write(strToBytes);
            } catch (IOException ex) {

            }

            try {
                outputStream.close();
            } catch (IOException ex) {

            }
        }
    }

}
