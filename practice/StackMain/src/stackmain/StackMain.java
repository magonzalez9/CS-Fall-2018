/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackmain;

import java.util.Scanner;

/**
 *
 * @author Marco Gonzalez
 */
public class StackMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sentence = "marco likes chicken";
        Stack myStack = new Stack(sentence.length());

        // Use stack for bracket matching
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string with bracket");
        String strInput = input.nextLine();

        Stack bMatcher = new Stack(strInput.length());
        String errorMsg = "";

        for (int i = 0; i < strInput.length(); i++) {
            char ch = strInput.charAt(i);
            // Push left brackets onto the stack
            switch (strInput.charAt(i)) {
                case '{':
                case '(':
                case '[':
                    bMatcher.push(strInput.charAt(i));
                    break;
                case '}':
                case ')':
                case ']':
                    if (!bMatcher.isEmpty()) {

                        char chx = bMatcher.pop();
                        if ((ch == '}' && chx != '{') || (ch == ')' && chx != '(') || (ch == ']' && chx != '[')) {
                            errorMsg = "Match error";
                        }
                    } else {
                        errorMsg = "Stack is empty";

                    }
                default:
                    break;
            }
        }
        if (!bMatcher.isEmpty()) {
            System.out.println("Too many left brackets");
        } else if (errorMsg.equals("")) {
            System.out.println(errorMsg);
        } else {
            System.out.println("Success");
        }
    }

}
