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
        
        LinkedList linked = new LinkedList();
        
        linked.addLast(1);
        linked.addLast(2);
        linked.addFirst(7);
        linked.addLast(0);
        System.out.println(linked.size());
        for (int i = 0; i < 10; i++) {
            linked.contains(i);
        }

        
        System.out.println(linked.toString());
    }

}
