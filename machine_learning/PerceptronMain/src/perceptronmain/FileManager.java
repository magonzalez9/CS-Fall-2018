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

    public void openFile(String dir) {
        // FileChooser object definition and StringBuilder creation
        JFileChooser fileChooser = new JFileChooser();
        StringBuilder fileContents = new StringBuilder();

        // Prompt user to select file
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            dir = file.getAbsolutePath();

            try {
                BufferedReader in;
                in = new BufferedReader(new FileReader(file));
                String line = in.readLine();
                while (line != null) {
                    fileContents.append(line);
                    line = in.readLine();

                }
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {

            }
        }
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
