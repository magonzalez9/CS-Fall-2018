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
public class DoublyLinkedList {

    Node head;
    Node tail;

    public void addLast(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(data);
        current.next = newNode;
        newNode.prev = current;

    }

    public void deleteByValue(int data) {
        if (head.data == data && head.next != null) {
            head = head.next;
            return;
        } else if (head.data == data && head.next == null) {
            head = null;
            return;
        }

        Node current = head.next;
        while (current.next != null) {
            if (current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }

        // Check the last node 
        if (current.data == data) {
            current.prev.next = null;
            current.prev = null;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        sb.append(head.toString());
        while (current.next != null) {
            current = current.next;
            sb.append(current.toString());
        }

        return sb.toString();

    }
}
