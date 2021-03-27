/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

/**
 *
 * @author Yusuf Abdullah abdulwahab
 */
/**
 * @(#) DataItem.java
 *
 * Data Item class used to demonstrate 'open addressing' hash table with linear
 * probing. Note for simplicity the properties are declared as public and no
 * set/get methods have been provided.
 *
 *
 */
public class DataItem implements Comparable {

    private String key;
    private String info;

    /**
     * Constructor to create instance of a DataItem
     *
     * @param nkey key value to identify data item
     * @param ninfo info to store in data item
     */
    public DataItem(String nkey, String ninfo) {
        key = nkey;
        info = ninfo;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Test if the supplied Object is an instance of a DataItem and its key
     * value is equal to the key value of the current DataItem.
     *
     * @param anObject object to test for equality
     * @return true if equal and false otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        if ((anObject != null) && (anObject instanceof DataItem)) {
            DataItem d = (DataItem) anObject;
            return key.equals(d.key);
        }
        return false;
    }

    @Override
    public int compareTo(Object anObject) {
        if (!(anObject instanceof DataItem)) {
            return -1;
        } else {
            String s = (String) anObject;
            return key.compareTo(s);
        }

    }

    /**
     * Return a printable representation of a DataItem
     *
     * @return String representation of a DataItem.
     */
    @Override
    public String toString() {
        return "(Key:" + key + ", Info:" + info + ")";
    }

}
