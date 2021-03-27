/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
/**
 * @(#) HashTableChaining.java
 *
 * Implements a Chaining HashTable Implementation.
 *
 */
// import linked list package here
import Lab5.*;

public class HashTableChaining {

    private CircularDoubleLinkedGenerics[] hashArray;	// Array of Lists 
    private int nElems;			// number of elements in hashtable 

    /**
     * Default Constructor Creates a Hash Table capable of holding 11 items
     */
    public HashTableChaining() {
        this(11);
    }

    /**
     * Constructor creates HashTable of Specified size
     *
     * @param size size of hashtable to create
     */
    public HashTableChaining(int size) {
        nElems = 0;
        hashArray = new CircularDoubleLinkedGenerics[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new CircularDoubleLinkedGenerics();
        }
    }

    /**
     * Hash function generates hash value from key
     *
     * @param key key to hash
     * @param tableSize size of table key is generated for
     * @return hash value
     */
    public int hashFunc(String key, int tableSize) {
        int i, sum = 0;
        for (i = 0; i < key.length(); i++) {
            sum = sum + (int) key.charAt(i);
        }
        return sum % tableSize;
    }

    /**
     * Provide printable representation of a hashtable
     *
     * @return String representation
     */
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

    /**
     * Insert a DataItem into the hash table
     *
     * @param item DataItem to insert
     */
    public void insert(DataItem item) {
        int hashVal = hashFunc(item.getKey(), hashArray.length);  // hash the key

        int x = hashArray[hashVal].indexOf(item);
        if (x == -1) {
            hashArray[hashVal].insertLast(item);
        } else {
            System.out.println("the element is exist");
        }

        // COMPLETE THIS METHOD, add element to list identified by the hash 
        // increment number of elements 
    }

    /**
     * Delete DataItem from HashTable identified by specified key
     *
     * @param key key identifying DataItem to delete
     * @return copy of deleted data item if found, otherwise null
     */
    public DataItem delete(String key) {
        int hashVal = hashFunc(key, hashArray.length);  // hash the key
        DataItem d = null;
        DataItem d1 = new DataItem(key, null);

        int x = hashArray[hashVal].indexOf(d1);
        if (x != -1) {
            d = (DataItem) hashArray[hashVal].retrieve(x).getiData();
            hashArray[hashVal].remove(x);
            nElems--;
            return d;
        }
        return null;
        // COMPLETE THIS METHOD – locate element in list identified by hash
        // take copy of the element, delete it from the list
        // and return the copy. If its not found return null
    }

    /**
     * Search hash table for DataItem identifed by specifed key
     *
     * @param key key identifying DataItem to locate
     * @return DataItem if found otherwise null
     */
    public DataItem find1(String key) {
        int hashVal = hashFunc(key, hashArray.length);  // hash the key

        DataItem d = new DataItem(key, null);
        int x = hashArray[hashVal].indexOf(d);
        if (x != -1) {
            d = (DataItem) hashArray[hashVal].retrieve(x).getiData();
            return d;
        }
        return null;
        // COMPLETE THIS METHOD, locate element in list identified by hash,
        // if found return element as method result, otherwise return null
    }

}
