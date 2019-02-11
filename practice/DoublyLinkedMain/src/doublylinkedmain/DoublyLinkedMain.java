/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedmain;

import java.util.*;

/**
 *
 * @author Marco
 */
public class DoublyLinkedMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList dList = new DoublyLinkedList();

        dList.addFirst(2);
        dList.addFirst(1);
        dList.addLast(7);

        System.out.println(dList.toString());
    }

}
