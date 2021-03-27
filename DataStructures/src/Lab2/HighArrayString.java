/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ysuuf Abdullah Abdulwahab
 */
public class HighArrayString {

    protected String[] a;
    protected int nElems;
    protected final int INITIALSIZE = 2;
    protected int size;

    public HighArrayString() {
        a = new String[INITIALSIZE];
        nElems = 0;
        size = INITIALSIZE;
    }
//-----------------------------------------------------------

    public void insert(String s) {
        if (size == nElems) {
            size *= 2;
            String[] copy = new String[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        a[nElems] = s;
        nElems++;
    }
//-----------------------------------------------------------

    public void insertOrdered(String s) {
        if (size == nElems) {
            size *= 2;
            String[] copy = new String[size];
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

    public int binarySearch(String s) {
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
    public boolean find(String s) {
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

    public int findAll(String s) {
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

    public boolean delete(String s) {
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

    public boolean deleteAll(String s) {
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
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }
//-----------------------------------------------------------

    public int size() {
        return nElems;
    }
//-----------------------------------------------------------

    public void readIntFile(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextLine()) {
            String s = input.nextLine();
            insert(s);
        }
    }
}
