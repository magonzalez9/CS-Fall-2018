/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistmain;

/**
 *
 * @author Marco Gonzalez
 */
public class LinkedList {

    Node head;

    public void addFirst(int data) {
        Node newHead = new Node(data);
        newHead.next = head;

        head = newHead;
    }

    public void addLast(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head; // Begin at head
        while (current.next != null) {
            // Traverse the nodes until we reach the last one pointing to null
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (!isEmpty()) {
            if (head.next == null) {
                head = null;
                return;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.next == null) {
                    current.next = null;
                    return;
                }
                current = current.next;
            }

        }
    }

    public void deleteByValue(int data) {
        // Check if LinkedList is empty
        if (isEmpty()) {
            return;
        }

        // Check if data is at head
        if (head.data == data) {
            head = head.next;
            return;
        }

        // Find nodes matching data
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next; // move to the next element
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "No data";
        }
        StringBuilder sb = new StringBuilder();

        Node current = head;
        sb.append(head.toString());
        while (current.next != null) {
            sb.append(current.next.toString());
            current = current.next;
        }
        return sb.toString();
    }

}
