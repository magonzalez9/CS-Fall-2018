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

    public void addFirst(int data) {
        if (isEmpty()) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        if (isEmpty()) {
            head = new Node(data);
            return;
        }

        // Get last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Insert new Node
        Node newNode = new Node(data);
        current.next = newNode;
        newNode.prev = current;

    }

    public void deleteFirst() {
        if (!isEmpty()) {
            // Deletion at FIRST node
            if (head.next != null) {
                // Multiple nodes left
                head = head.next;
                head.prev.next = null;
            } else if (head.next == null) {
                // Only 1 node left
                head = null;
            }
        }
    }

    public void deleteLast() {
        if (!isEmpty()) {
            if (head.next == null) {
                deleteFirst();
                return;
            }

            Node current = head.next;
            while (current.next != null) {
                current = current.next;
            }

            // Deletion at LAST node
            current.prev.next = null;
            current.prev = null;
        }

    }

    public void deleteByValue(int data) {
        // Deletion at FIRST node
        if (head.data == data && head.next != null) {
            // Multiple nodes left
            head = head.next;
            head.prev.next = null;
            return;
        } else if (head.data == data && head.next == null) {
            // Only 1 node left
            head = null;
            return;
        }

        Node current = head.next;
        while (current.next != null) {
            if (current.data == data) {
                // Deletion at MIDDLE nodes
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }

        // Deletion at LAST node
        if (current.data == data) {
            current.prev.next = null;
            current.prev = null;
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "No Data";
        }

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
