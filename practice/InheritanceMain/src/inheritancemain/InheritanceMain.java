/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancemain;

import java.util.*;

/**
 *
 * @author Marco Gonzalez
 */
public class InheritanceMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<Integer, Programmer> myMap = new HashMap<>();
        Programmer marco = new Programmer(619, "Marco", "Gonzalez", "Male", 10, "Java", true);
        Programmer eric = new Programmer(619, "Eric", "Queefe", "Female", 10, "JPIF", true);

        myMap.put(0, marco);
        myMap.put(1, eric);

        myMap.get(0).updateData(Programmer.LANGUAGE, "Python");
        eric.updateData(Programmer.LANGUAGE, "Assembly");
        
        System.out.println(MyList.LIST_COUNT);

        System.out.println(myMap.get(0).getList().toString());
        System.out.println(myMap.get(1).getList().toString());

    }

}
