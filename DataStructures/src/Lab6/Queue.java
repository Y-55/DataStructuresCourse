/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

import Lab5.CircularDoubleLinkedGenerics;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 * @param <T>
 * 
 */
public class Queue<T extends Comparable> {

    protected CircularDoubleLinkedGenerics<T> queue;

    public Queue() {
        this.queue = new CircularDoubleLinkedGenerics<>();
    }

    public CircularDoubleLinkedGenerics<T> getQueue() {
        return queue;
    }

    public void setQueue(CircularDoubleLinkedGenerics<T> queue) {
        this.queue = queue;
    }

    public void enqueue(T a) {
        this.queue.insertFirst(a);
    }

    public T dequeue() {
        return this.queue.deleteLast();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
    
    public void display(){
        this.queue.displayList();
    }
    
}
