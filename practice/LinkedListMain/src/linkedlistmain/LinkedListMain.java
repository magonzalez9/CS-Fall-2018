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
      
      myList.append(1);
      myList.append(2);
      myList.append(3);
      myList.append(4);
      
      myList.deleteWithValue(3);
      
      System.out.println(myList.toString());
      
      // Reverse a linked list
      

        
    
      
    }
    
}
