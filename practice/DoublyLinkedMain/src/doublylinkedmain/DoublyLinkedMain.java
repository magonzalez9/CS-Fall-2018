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
        
        LinkedList<Integer> stack = new LinkedList(); 
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop(); 
        stack.pop(); 
        stack.peek(); 
        System.out.println(stack.toString());
    }

}
