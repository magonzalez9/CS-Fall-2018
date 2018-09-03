/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmain;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class StringList extends ArrayList<String> {

    @Override
    public String toString() {
        StringBuilder fileContent = new StringBuilder();
        for (String aThi : this) {
            fileContent.append(aThi);
        }
        return fileContent.toString();
    }

}
