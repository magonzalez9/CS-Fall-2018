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
public class Node {

    Node next;
    Node prev;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public String toString() {
        return "{" + data + "}";
    }

}
