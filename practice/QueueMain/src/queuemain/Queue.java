/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemain;

import java.util.Arrays;

/**
 *
 * @author Marco Gonzalez
 */
public class Queue {

    private int maxSize;
    private char[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new char[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(char value) {
        if (rear == maxSize - 1) {
            rear = -1; // Deal w/ wrap around
        }
        queArray[++rear] = value;
        nItems++;
    }

    public char remove() {
        char temp = queArray[front++];
        if (front == maxSize-1) {
            front = 0; // Deal w/ wrap around
        }
        nItems--;
        return temp;
    }

    public char peek() {
        return queArray[front];
    }

    public boolean isFull() {
        return (nItems == maxSize - 1);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public int size() {
        return nItems;
    }

    public String toString() {
        return Arrays.toString(queArray);
    }

}
