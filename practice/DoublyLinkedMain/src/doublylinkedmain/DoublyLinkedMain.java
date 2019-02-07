/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedmain;

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
        DLinkedList dList = new DLinkedList(); 
        dList.append(1);
        dList.append(2);
        dList.append(3);
        dList.append(4);
        
        dList.deleteByValue(2);
        dList.deleteByValue(1);
        dList.deleteByValue(4);
        
        
        System.out.println(dList.toString());
    }
    
}
