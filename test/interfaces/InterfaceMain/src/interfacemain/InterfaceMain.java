/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacemain;

import java.util.List;

/**
 *
 * @author Marco
 */
public class InterfaceMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ListClientExample t = new ListClientExample();
        List myList = t.getList();
        
        myList.add(2);
        myList.add(3);
        
        System.out.println(myList.toString());

    }

}
