/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ4;

import BonusQuestionsQ3.Word;
import java.util.LinkedList;

/**
 *
 * @author Yusuf Abdulwahab
 */
public class WordHeap {

    protected LinkedList<Word> heapWord;
    protected int lastIndex;

    public WordHeap() {
        heapWord = new LinkedList<>();
    }

    public void insert(Word word) {
        int index = heapWord.indexOf(word);
        
        if (index == -1) {
            heapWord.addLast(word);
            lastIndex++;
            heapWord.get(lastIndex).setHeapIndex(lastIndex);
        } else {
            
        }
    }
}
