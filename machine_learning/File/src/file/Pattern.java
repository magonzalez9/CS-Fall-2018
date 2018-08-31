/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author Marco Gonzalez
 */
public class Pattern {

    StringList text = new StringList();

    public void appendString(String str) {
        text.add(str);
    }

    public void clear() {
        text.clear();
    }

    public String getTextContent() {
        return text.toString();
    }
}
