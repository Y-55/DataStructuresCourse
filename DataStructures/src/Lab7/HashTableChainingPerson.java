/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import Lab1.Person;
import Lab5.*;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class HashTableChainingPerson {

    protected int nElems;
    protected CircularDoubleLinkedGenerics[] hashArray;

    public HashTableChainingPerson(int size) {
        this.nElems = 0;
        hashArray = new CircularDoubleLinkedGenerics[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new CircularDoubleLinkedGenerics();
        }
    }

    public HashTableChainingPerson() {
        this(11);
    }

    public int hashFunc(String key, int length) {
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        sum %= length;
        return sum;
    }

    public void insert(Person p) {
        int hashVal = hashFunc(p.getPID(), hashArray.length);

        if (hashArray[hashVal].indexOf(p) != -1) {
            System.out.println("the element is exist");
            return;
        }
        hashArray[hashVal].insertLast(p);
        nElems++;
    }

    public Person find(String key) {
        int hashVal = hashFunc(key, hashArray.length);
        Person p = new Person(null, key);

        int x = hashArray[hashVal].indexOf(p);
        if (x != -1) {
            return (Person) hashArray[hashVal].retrieve(x).getiData();
        }
        return null;
    }

    public Person delete(String key) {
        int hashVal = hashFunc(key, hashArray.length);
        Person p = new Person(null, key);

        int x = hashArray[hashVal].indexOf(p);
        if (x == -1) {
            return null;
        }
        p = (Person) hashArray[hashVal].retrieve(x).getiData();
        hashArray[hashVal].remove(x);
        nElems--;
        return p;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for (int j = 0; j < hashArray.length; j++) {
            if (hashArray[j].isEmpty()) {
                buffer.append("empty link\n");
            } else {
                buffer.append(hashArray[j].toString() + "\n");
            }
        }
        return buffer.toString();
    }

    /**
     * Display Elements in HashTable
     *
     */
    public void print() {
        System.out.println(this.toString());
    }
}
