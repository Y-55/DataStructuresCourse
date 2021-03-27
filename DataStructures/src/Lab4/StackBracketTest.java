/*
 * To change this license header, choose License Headers in Project Properties.h
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import java.util.Scanner;


/**
 * Implement a Symbol Balancer. Which tests and expression containing brackets
 * [](){} and determines if brackets are balanced. Implementation uses a
 * StackArray.
 *
 * @version 1.0 08
 * @author
 */
public class StackBracketTest {

    private String input;

    /**
     * Default Constructor
     *
     */
    public StackBracketTest() {
        input = null;
    }

    /**
     * Alternate Constructor Sets Expression to be evaluated
     *
     * @param in string containing expression to be balanced
     */
    public StackBracketTest(String in) {
        input = in;
    }

    /**
     * Set string containing expression to be evaluated
     *
     * @param in string containing expression to be balanced
     */
    public void setExpression(String in) {
        input = in;
    }

    /**
     * Evaluate expression and determine correctness
     *
     * @return
     */
    public boolean check() {
        int stackSize = input.length();
        StackArray stack = new StackArray();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '{':
                case '(':
                case '[':

                    stack.push(ch);
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                    break;
                case '"':
                    if (stack.peek() == '"') {
                        stack.pop();
                    }
                    else{
                        stack.push(ch);
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    /**
     * This main method implements a little interactive test program which when
     * executed repeatedly prompts the user for an expression and tests the
     * expression.
     *
     * @param args
     */
    public static void main(String[] args) {

        String input;
        StackBracketTest test = new StackBracketTest();
        Scanner in = new Scanner(System.in);

        // Declare a variable of type StackBracketTest and create 
        // and assign to it an instance of StackBracketTest class. 
        // Which would be the most appropriate constructor to use here?
        // note this is a do while loop which is different to a while
        // loop in that it will always execute at least once. 
        // Can you determine what condition causes the loop to terminate? 
        do {
            System.out.print("Enter string containing delimiters: ");
            input = in.nextLine();

            // can you determine what this if statement is doing?  
            if (!input.equals("")) // pass the string to the StackBracketTest object created
            {
                test.setExpression(input);
                System.out.println(test.check() ? "This statement is valid" : "This statement is not valid");
            }

            // above using the most appropriate method.
            // Call the StackBracketTest check method.
            // Test result of check method and display result in form of
            // a message to the user e.g. “This statement is valid” 
            {

            }
        } while (!input.equals(""));
    }
}
