/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ3;

import java.util.LinkedList;

/**
 *
 * @author Yusuf Abdulwahab
 */
public class WordHashtable {

    protected LinkedList<Word>[] hash;
    protected int size;
    private int uniqueWords;
    private int numCollisions;

    public WordHashtable(int size) {
        this.size = size;
        this.hash = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.hash[i] = new LinkedList<>();
        }
        this.uniqueWords = 0;
        this.numCollisions = 0;
    }

    public int getUniqueWords() {
        return uniqueWords;
    }

    public int getNumCollisions() {
        return numCollisions;
    }

    public void insert(String w) {
        w = w.toLowerCase();
        int hashVal = hashFunc(w);
        int place = this.hash[hashVal].indexOf(new Word(w));

        if (place == -1) {
            if (this.hash[hashVal].isEmpty()) {
                numCollisions++;
            }
            this.hash[hashVal].addLast(new Word(w));
            uniqueWords++;

        } else {
            this.hash[hashVal].get(place).incrementFrequency();

        }

    }

    public int hashFunc(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x >= 97 && x <= 122) {
                sum += x;
            }
        }
        return sum % size;
    }

    public int getFrequency(String s) {
        s = s.toLowerCase();
        int hashVal = hashFunc(s);
        int place = this.hash[hashVal].indexOf(new Word(s));

        if (place != -1) {
            return this.hash[hashVal].get(place).getFrequency();
        } else {
            return -1;
        }
    }
}
