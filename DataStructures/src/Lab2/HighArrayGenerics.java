/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

/**
 *
 * @author yoooo
 */
public class HighArrayGenerics<T> {

    protected Object a[];
    protected int nElems;

    public HighArrayGenerics(int max) {
        a = new Object[max];
        nElems = 0;
    }

    public boolean find(T searchKey) {                              // find specified value
        int j;
        for (j = 0; j < nElems; j++) // for each element,
        {

            if (a[j].equals(searchKey)) // found item?
            {
                break;                       // exit loop before end
            }
        }
        if (j == nElems) // gone to end?
        {
            return false;                   // yes, can't find it
        } else {
            return true;                    // no, found it
        }
    }  // end find()

    public void insert(T value) // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    public boolean delete(T value) {
        int j;
        for (j = 0; j < nElems; j++) // look for it
        {
            if (value.equals(a[j])) {
                break;
            }
        }
        if (j == nElems) // can't find it
        {
            return false;
        } else // found it
        {
            for (int k = j; k < nElems; k++) // move higher ones down
            {
                a[k] = a[k + 1];
            }
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------

    public boolean deleteAll(T value) {
        boolean condition = false;
        for (int i = 0; i < nElems; i++) {
            while (a[i].equals(value)) {
                for (int j = i; j < nElems; j++) {
                    a[j] = a[j + 1];
                }
                nElems--;
                condition = true;
            }
        }
        return condition;
    }

    public int findAll(T value) {
        int counter = 0;
        for (int i = 0; i < nElems; i++) {
            if (a[i].equals(value)) {
                counter++;
            }
        }
        if (counter == 0) {
            return -1;
        } else {
            return counter;
        }
    }

    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
        {
            System.out.print(a[j] + " ");  // display it
        }
        System.out.println("");
    }

    public int size() {
        return nElems;
    }
}
