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
 * @(#) HashTableLinear.java
 *
 * HashTable implementation Using Open Addressing and Linear Probing.
 *
 */
public class HashTableLinear {

    private DataItem[] hashArray; // array holds hash table
    private int nElems;           // number of elements in hashtable
    private int size;

    private static final int DEFAULT_SIZE = 11; // default size

    /**
     * Default Constructor Creates a Hash Table of default size
     */
    public HashTableLinear() {
        this(DEFAULT_SIZE);
        size = 11;
    }

    /**
     * Constructor to create Hash Table of specified size
     *
     * @param size size of hash table to create
     */
    public HashTableLinear(int size) {
        nElems = 0;
        this.size = size;
        hashArray = new DataItem[size];
        for (int i = 0; i < hashArray.length; i++) {
            hashArray[i] = null;
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
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {
            sum = sum + (int) key.charAt(i);
        }
        return sum % tableSize;
    }

    /**
     * Insert a DataItem into the hash table
     *
     * @param item dataitem to insert
     */
    public void insert(DataItem item) {
        int hashVal = hashFunc(item.getKey(), this.hashArray.length); // hash the key

        if (find(item.getKey()) != null) {
            System.out.println("the element is alredy exist in the hash table");
            return;
        }
        int counter = 0;
        // loop until empty cell
        while (hashArray[hashVal] != null) {

            if (counter == size) {
                System.out.println("the hash table is full cannot insert an element");
                return;
            }
            counter++;
            hashVal++;                            // go to next cell
            hashVal = hashVal % hashArray.length; // wrap around if necessary
        }
        hashArray[hashVal] = item;              // insert item
        nElems++;                               // increase element count
    }

    /**
     * Delete DataItem from HashTable identified by specified key
     *
     * @param target
     * @return copy of deleted data item if found, otherwise null
     */
    public DataItem delete(String target) {
        int hashVal = hashFunc(target, hashArray.length); // hash the key
        int counter = 0;
        // loop until empty cell
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey().equals(target)) { // if found key
                DataItem temp = hashArray[hashVal];       // save item
                hashArray[hashVal] = null;                // delete item
                nElems--;                       // decrease element count
                return temp;                    // return item
            }
            if (counter == size) {
                return null;
            }
            counter++;
            hashVal++;                        // go to next cell
            hashVal = hashVal % hashArray.length; // wraparound if necessary
        }
        return null;                        // can't find item
    }

    /**
     * Search hash table for DataItem identifed by specifed key
     *
     * @param target
     * @return DataItem if found otherwise null
     */
    public DataItem find(String target) {
        int hashVal = hashFunc(target, hashArray.length); // hash the key
        int counter = 0;

        // loop until empty cell,
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey().equals(target)) { // if found key
                return hashArray[hashVal];
            }
            if (counter == size) {
                return null;
            }
            counter++;
            hashVal++;                             // go to next cell
            hashVal = hashVal % hashArray.length;  // wraparound if necessary
        }
        return null;                             // can't find item
    }

    /**
     * Provide printable representation of a hashtable
     *
     * @return String representation
     */
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
