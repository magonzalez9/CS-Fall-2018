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
public class TreesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryTree myTree = new BinaryTree(); 
        myTree.addNode(18);
        
        myTree.addNode(21);
        myTree.addNode(22);
        myTree.addNode(20);
        myTree.addNode(6);
        myTree.addNode(4); 
        myTree.addNode(3);

        myTree.printInOrder(myTree.root);
        System.out.println("");
        myTree.printPreOrder(myTree.root.rightChild);
        System.out.println("");
        myTree.printPostOrder(myTree.root.rightChild.rightChild);
    }
    
}
