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
//performance------------------------------------------------------------------------------------------------------------------
public class ListOpsIter {

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

        ListIterator itrA = new ListIterator(a);

        for (int i = 0; i < a.length(); i++) {
            Node x = itrA.getCurrent();
            if (b.indexOf(x) != -1 && u.indexOf(x) == -1) {
                u.insertFirst(x.getiData());
            }
            itrA.nextLink();
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

        ListIterator iterA = new ListIterator(a);
        ListIterator iterB = new ListIterator(b);

        for (int i = 0; i < a.length(); i++) {
            if (u.indexOf(iterA.getCurrent()) == -1) {
                u.insertFirst(iterA.getCurrent().getiData());
            }

            iterA.nextLink();
        }
        for (int i = 0; i < b.length(); i++) {

            if (u.indexOf(iterB.getCurrent()) == -1) {
                u.insertFirst(iterB.getCurrent().getiData());
            }
            iterB.nextLink();
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

        ListIterator iterA = new ListIterator(a);
        ListIterator iterB = new ListIterator(b);

        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(iterA.getCurrent()) == -1 && u.indexOf(iterA.getCurrent()) == -1) {
                u.insertFirst(iterA.getCurrent().getiData());
            }
            iterA.nextLink();
        }
        for (int i = 0; i < b.length(); i++){
             if (a.indexOf(iterB.getCurrent()) == -1 && u.indexOf(iterB.getCurrent()) == -1) {
                u.insertFirst(iterB.getCurrent().getiData());
            }
            iterB.nextLink();
        }
        return u;
    }

}
