/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class ListOps {

    /**
     * Return new List Which is formed by Intersection of Two specified list
     * parameters (i.e. elements common to both lists)
     *
     * @param a LinkList
     * @param b LinkList
     * @return a new LinkedList formed by Intersection
     */
    public static LinkList intersection(LinkList a, LinkList b) {

        LinkList u = new LinkList();

        for (int i = 0; i < a.length(); i++) {

            if (b.indexOf(a.retrieve(i)) != -1) {
                u.insert(0, a.retrieve(i));
            }
        }
        return u;
    }

    /**
     * Return new LinkList formed by Union of two Lists specified as Parameters
     * (i.e. elements in both lists but not duplicated)
     *
     * @param a LinkList
     * @param b LinkList
     * @return new LinkList formed by Union
     */
    public static LinkList union(LinkList a, LinkList b) {
        LinkList u = new LinkList();
        for (int i = 0; i < a.length(); i++) {
            u.insert(0, a.retrieve(i));
            
        }
        for (int i = 0; i < b.length(); i++) {
            if (a.indexOf(b.retrieve(i)) == -1) {  
                u.insert(0, b.retrieve(i));
            }
        }
        return u;
    }

    /**
     * Return new List Which is formed by difference of two specified list
     * parameters (i.e. elements not common to both lists)
     *
     * @param a LinkList
     * @param b LinkList
     * @return new LinkList formed by complement
     */
    public static LinkList difference(LinkList a, LinkList b) {
        // set of elements not common to a and b
        LinkList u = new LinkList();
        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(a.retrieve(i)) == -1) {
                u.insert(0, a.retrieve(i));
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (a.indexOf(b.retrieve(i)) == -1) {
                u.insert(0, b.retrieve(i));
            }
        }
        return u;
    }

}
