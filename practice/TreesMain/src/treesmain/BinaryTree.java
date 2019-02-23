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
public class BinaryTree {

    Node root;

    public void addNode(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Node current = root;
        Node newNode = new Node(data);

        while (current != null) {
            if (data < current.data) {
                // Attempt to try to add to left 
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                } else {
                    current = current.leftChild;
                }
            } else if (data > current.data) {
                // Add to right 
                if (current.rightChild == null) {
                    current.rightChild = newNode;

                } else {
                    current = current.rightChild;
                }
            } else {
                return;
            }
        }
    }

    public boolean contains(int data) {
        if (root == null) {
            return false;
        }

        Node current = root;

        while (current != null) {
            if (data == current.data) {
                return true;
            } else if (data < current.data) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        return false;
    }
    
    public void deleteNode(int x){
        
    }

    public void printInOrder(Node focusNode) {

        if (focusNode != null) {
            printInOrder(focusNode.leftChild);
            System.out.print(focusNode);
            printInOrder(focusNode.rightChild);
        }

    }

    public void printPreOrder(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode);
            printPreOrder(focusNode.leftChild);
            printPreOrder(focusNode.rightChild);
        }
    }

    public void printPostOrder(Node focusNode) {

        if (focusNode != null) {
            printPostOrder(focusNode.leftChild);
            printPostOrder(focusNode.rightChild);
            System.out.print(focusNode);
        }

    }
    
    

}
