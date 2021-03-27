/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import Lab2.HighArray;


/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class QueueArray {

    protected HighArray Queue;

    public QueueArray() {
        Queue = new HighArray();
    }

    public void enqueue(long a) {
        this.Queue.insert(a);
    }

    public long dequeue() {
        return this.Queue.removeFirst();
    }

    public boolean isEmpty() {
        if (this.Queue.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
