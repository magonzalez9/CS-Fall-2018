/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treesmain;

/**
 *
 * @author Marco Gonzalez
 */
public class Node {

    int data;

    Node leftChild;
    Node rightChild;

    Node(int data) {
        this.data = data;

    }

    public String toString() {
        return "(" + data + ")";
    }
}
