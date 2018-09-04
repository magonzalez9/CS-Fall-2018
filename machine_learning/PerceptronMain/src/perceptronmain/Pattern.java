/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Marco
 */
public class Pattern {

    StringList list;
    String pathname;  // pathname this file, for use in the header

    Pattern() {
        list = new StringList();
    }

    Pattern(File f) throws FileNotFoundException, IOException {
        this();
        pathname = f.getName();
        FileManager fileManagerObj = new FileManager();

        // add text while next line to stringlist 'list'
        if (f.isFile()) {
            try {
                BufferedReader in = fileManagerObj.getFileContent(f);
                String line = in.readLine();
                while (line != null) {
                    list.add(line);
                    line = in.readLine();
                }
            } catch (FileNotFoundException ex) {
                System.out.println("FILE NOT FOUND");
            }
        }// End of if is file
    } // -- End of Pattern constructor

    @Override
    public String toString() {
        String returnMe = "\n" + "***********************************"+"\n"+
                           pathname + "\n" +"***********************************" + "\n";
        for (String nextString : list) {
            returnMe += "\n\t" + nextString;
        }

        return returnMe;
    }
}
