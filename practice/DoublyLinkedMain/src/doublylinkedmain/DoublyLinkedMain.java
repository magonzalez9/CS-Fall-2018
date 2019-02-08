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

        Deque<String> a = new ArrayDeque();
//        a.push("s");
//        a.push("i");
//        a.push("n");
//        a.push("e");
//        a.push("p");
        
        a.add("s");
        a.add("i");
        a.add("n");
        a.add("e");
        a.add("p");
       
        
        System.out.println(a.toString());
        System.out.println(a.remove());
    }

}
