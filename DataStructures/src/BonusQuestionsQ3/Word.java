/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ3;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class Word {

    private String word;
    private int frequency;
    protected int heapIndex;

    public Word(String word) {
        this.word = word;
        this.frequency = 1;
        heapIndex = -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Word)) {
            return false;
        } else {
            Word w = (Word) obj;
            return word.equalsIgnoreCase(w.getWord());
        }
    }

    public void incrementFrequency() {
        frequency++;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getHeapIndex() {
        return heapIndex;
    }

    public void setHeapIndex(int heapIndex) {
        this.heapIndex = heapIndex;
    }
}
