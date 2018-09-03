/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronmain;

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

    public void appendString(String str) {
        list.add(str);
    }

    public void clear() {
        list.clear();
    }

    public String getTextContent() {
        return list.toString();
    }
}
