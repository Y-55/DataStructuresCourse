/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Lab1.Person;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class HighArrayPerson {

    protected Person[] a;
    protected int nElems;
    private final int INITIALSIZE = 2;
    private int size;

    public HighArrayPerson() {
        a = new Person[INITIALSIZE];
        nElems = 0;
        size =INITIALSIZE;
        
         
    }
//-----------------------------------------------------------

    public void insert(Person s) {
         if (size == nElems) {
            size *= 2;
           Person[] copy = new Person[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        a[nElems] = s;
        nElems++;
    }
//-----------------------------------------------------------

    public void insertOrdered(Person s) {
        if (size == nElems) {
            size *= 2;
           Person[] copy = new Person[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i].compareTo(s) > 0) {
                break;
            }
        }
        for (int k = nElems; k > i; k--) {
            a[k] = a[k - 1];
        }
        a[i] = s;
        nElems++;
    }
//-----------------------------------------------------------

    public int binarySearch(Person s) {
        int left = 0;
        int right = nElems - 1;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (a[pivot].equals(s)) {
                return pivot;
            } else if (a[pivot].compareTo(s) > 0) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

//-----------------------------------------------------------
    public boolean find(Person s) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i].equals(s)) {
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else {
            return true;
        }
    }
//-----------------------------------------------------------

    public int findAll(Person s) {
        int counter = 0;
        for (int i = 0; i < nElems; i++) {
            if (a[i].equals(s)) {
                counter++;
            }
        }
        if (counter == 0) {
            return -1;
        } else {
            return counter;
        }
    }
//-----------------------------------------------------------

    public boolean delete(Person s) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i].equals(s)) {
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else {
            for (; i < nElems; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
            return true;
        }

    }
//-----------------------------------------------------------

    public boolean deleteAll(Person s) {
        int i;
        boolean condition = false;
        for (i = 0; i < nElems; i++) {
            while (a[i].equals(s)) {
                for (int j = i; j < nElems; j++) {
                    a[i] = a[i + 1];
                }
                nElems--;
                condition = true;
            }
        }
        return condition;
    }
//-----------------------------------------------------------

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i]);
        }
    }
//-----------------------------------------------------------

    public int size() {
        return nElems;
    }
//-----------------------------------------------------------

    public void bubbleSort() {
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = 0; j < nElems - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j + 1, j);

                }
            }
        }
    }
//-----------------------------------------------------------

    public void selectinSort() {
        Person min = a[0];
        for (int i = 0; i < nElems; i++) {
            int indexOfMin = i;
            min = a[i];
            for (int j = i + 1; j < nElems; j++) {
                if (a[j].compareTo(min) < 0) {
                    min = a[j];
                    indexOfMin = j;
                    System.out.println(j);
                }
            }
            swap(a, indexOfMin, i);
        }
    }
//-----------------------------------------------------------

    public void insertionSort() {
        int i = 1;
        Person key;
        for (; i < nElems; i++) {
            int j = i - 1;
            key = a[i];
            while (j > -1 && (key.compareTo(a[j])) < 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
//-----------------------------------------------------------

    public void swap(Person[] a, int b, int c) {
        Person temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
//-----------------------------------------------------------

    public void readIntFile(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()) {
            String s = input.next();
            int a = input.nextInt();
            int b = input.nextInt();
            Person per = new Person(s, a, b);
            insert(per);
        }
    }
}
