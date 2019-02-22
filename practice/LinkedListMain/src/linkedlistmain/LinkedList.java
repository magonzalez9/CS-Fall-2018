/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistmain;

import java.util.*;

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

    // ----------------- Practice problems --------------------------------------
    public void deleteDuplicates() {
        if (isEmpty()) {
            return;
        }

        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (!hs.add(current.data)) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }

    public int getKthToLast(int k) {
        if (isEmpty()) {
            return 0;
        }
        Node previous = head;
        Node current = head;
        int currentK = 1;

        while (current.next != null) {
            if (currentK != k) {
                currentK++;
            } else {
                previous = previous.next;
            }
            current = current.next;
        }

        if (currentK == k) {
            return previous.data;
        } else {
            return 0;
        }
    }

    public void partionList(int x) {
        if (isEmpty()) {
            return;
        }

        Node leftHead = null;
        Node leftTail = null;
        Node rightHead = null;
        Node rightTail = null;

        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = null;

            if (current.data < x) {
                if (leftHead == null) {
                    leftTail = current;
                    leftHead = leftTail;
                } else {
                    leftTail.next = current;
                    leftTail = leftTail.next; // move pointer to next node
                }
            } else {
                if (rightHead == null) {
                    rightTail = current;
                    rightHead = rightTail;
                } else {
                    rightTail.next = current;
                    rightTail = rightTail.next; // move pointer to next node
                }
            }

            current = next;
        }

        leftTail.next = rightHead;
    }

    // Delete middle node
    public void deleteMiddleNode(Node n) {
        if (n.next != null && n != null) {
            n.data = n.next.data;
            n.next = n.next.next;
        }

    }

    public void reverseList() {
        if (head == null) {
            return;
        }

        Node current = head;
        Node newHead = null;

        while (current != null) {
            Node next = current.next; // Helper next pointer
            current.next = null;

            if (newHead == null) {
                newHead = current;
            } else {
                current.next = newHead;
                newHead = current;
            }

            current = next;
        }

        head = newHead;
    }

    // Reverse a linked list 
    // ----------------- Practice problems --------------------------------------
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
