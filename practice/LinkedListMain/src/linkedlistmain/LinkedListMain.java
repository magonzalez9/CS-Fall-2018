/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistmain;

import java.util.*;

/**
 *
 * @author Marco Gonzalez
 */
public class LinkedListMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList myList = new LinkedList();

        myList.addLast(3);
        myList.addLast(5);
        myList.addLast(8);
//        myList.addLast(5);
//        myList.addLast(10);
//        myList.addLast(2); 
//        myList.addLast(1);

        System.out.println(myList.toString());
        myList.reverseList();
        
        System.out.println(myList.toString());
        
        // Reverse a linked list
    }

}
