/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import Lab1.Person;

/**
 *
 * @author Yusuf Abdulwahab
 */
public class HashTableLinearPerson {

    protected int nElems;
    protected Person[] hashArray;
    protected static final int DEFAULT_SIZE = 11;

    public HashTableLinearPerson() {
        this(DEFAULT_SIZE);
    }

    public HashTableLinearPerson(int length) {
        hashArray = new Person[length];
        nElems = 0;
    }

    public int hashFunc(String key, int mode) {
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % mode;
    }

    public void insert(Person p) {
        int place = hashFunc(p.getPID(), hashArray.length);
        int counter = 0;

        //if its not null that mean the element is exists
        if (find(p.getPID()) != null) {
            System.out.println("the element is alredy exist in the hash table");
            return;
        }
        while (this.hashArray[place] != null) {
            if (counter == hashArray.length) {
                System.out.println("the hash table is full cannot insert an element");
                return;
            }
            place++;
            counter++;
            place = place % hashArray.length;
        }
        hashArray[place] = p;
        nElems++;
    }

    public Person delete(String key) {
        int place = hashFunc(key, hashArray.length);
        int counter = 0;

        while (hashArray[place] != null) {
            if (hashArray[place].getPID().equals(key)) {
                Person temp = hashArray[place];
                hashArray[place] = null;
                nElems--;
                return temp;
            }
            if (counter == hashArray.length) {
                return null;
            }
            place++;
            counter++;
            place = place % hashArray.length;
        }
        return null;
    }

    public Person find(String key) {
        int counter = 0;
        int place = hashFunc(key, hashArray.length);

        while (hashArray[place] != null) {
            if (hashArray[place].getPID().equals(key)) {
                return hashArray[place];
            }
            if (counter == hashArray.length) {
                return null;
            }
            place++;
            counter++;
            place = place % hashArray.length;
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == null) {
                buffer.append("empty\n");
            } else {
                buffer.append(hashArray[i] + "\n");
            }
        }
        return buffer.toString();
    }

    /**
     * Print Elements in HashTable to Console
     *
     */
    public void print() {
        System.out.println(this.toString());
    }
}
