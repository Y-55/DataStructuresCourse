/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ5;

import java.util.Scanner;

/**
 *
 * @author Yusuf Abdulwahab
 */
public class SequenceOfCharacters {

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a string terminated by '.':");
            String line = input.nextLine();
            int numberOfLe = report(line);
            if (numberOfLe != 0) {
                System.out.println("There are "+numberOfLe+" of \'le\'");
            } else {
                System.out.println("There is no occurrence of 'le'.");
            }
        }

    }

    public static int report(String line) {
        int counter = 0;
        String[] words = line.split(" ");
        for (String item : words) {
            char[] letters = item.toCharArray();
            for (int i = 0; i < letters.length - 1; i++) {
                if (letters[i] == 'l' && letters[i + 1] == 'e') {
                    counter++;
                }
            }
        }
        return counter;
    }
}
