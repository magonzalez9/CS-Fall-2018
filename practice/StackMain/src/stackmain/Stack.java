/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackmain;

import java.util.Arrays;

/**
 *
 * @author Marco Gonzalez
 */
public class Stack {

    private int maxSize;
    private char[] stackArray;
    private int top = -1;

    public Stack(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
    }

    public boolean push(char item) {
        if (!isFull()) {
            stackArray[++top] = item;
            return true;
        } else {
            System.out.println("Stack is full");
            return false;
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty");
            return ' ';
        }
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int size() {
        return maxSize;
    }

    @Override
    public String toString() {
        return Arrays.toString(stackArray);
    }
}
