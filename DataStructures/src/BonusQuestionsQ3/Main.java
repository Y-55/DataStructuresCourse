/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Yusuf Abdulwahab
 */
public class Main {

    public static void main(String[] arg) throws FileNotFoundException {
        int size = 1000;
        int freq = 0;
        WordHashtable hash = new WordHashtable(size);
        Scanner input = new Scanner(System.in);
        Scanner read = new Scanner(new File("read.txt"));
        while (read.hasNext()) {
            String word = read.next();
            hash.insert(word);
        }
        int linkSize;
        for (int i = 0; i < size; i++) {
            linkSize = hash.hash[i].size();
            for (int j = 0; j < linkSize; j++) {
                freq += hash.hash[i].get(j).getFrequency();
            }
        }
        System.out.println("java WordHashtable");
        System.out.println(freq + " words, " + hash.getNumCollisions() + " collisions," + hash.getUniqueWords() + " unique words\n");

        while (true) {
            System.out.println("enter a word to see its Frequency");
            String search = input.next();
            if (hash.getFrequency(search) != -1) {
                System.out.println("word " + search + " has Frequency " + hash.getFrequency(search));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
