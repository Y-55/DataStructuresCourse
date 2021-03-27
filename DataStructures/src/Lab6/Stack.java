/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 * @param <T>
 */
public class Stack<T> {

    protected Object[] a;
    protected int size;
    protected final int INIT = 2;
    protected int nElems;

    public Stack() {
        a = new Object[INIT];
        size = INIT;
        nElems = 0;
    }

    public void push(T x) {
        if (size == nElems) {
            size *= 2;
            Object[] copy = new Object[size];
            System.arraycopy(a, 0, copy, 0, nElems);
            a = copy;
        }
        a[nElems] = x;
        nElems++;
    }

    public T pop() {
        T temp = (T) a[nElems - 1];
        nElems--;
        if (size / 2 == nElems && size != 2) {
            size /= 2;
            Object[] copy = new Object[size];
            System.arraycopy(a, 0, copy, 0, nElems);
            a = copy;
        }
        return temp;
    }

    public T peek() {
        return (T) a[nElems - 1];
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
        {
            System.out.print(a[j] + " ");  // display it
        }
        System.out.println("");
    }
}
