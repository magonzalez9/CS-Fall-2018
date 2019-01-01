/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacemain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class ListClientExample {

    private List list;
    public static int m = 0; 

    public ListClientExample() {
        list = new LinkedList();
        m++;

    }

    public List getList() {
        return list;
    }
}
