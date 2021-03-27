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
public class GNode<T extends Comparable> {

    private T iData;              // data item (key)
    private GNode<T> next;              // next link in list
    private GNode<T> previous;
// -------------------------------------------------------------

    public GNode(T id) // constructor
    {
        iData = id;
    }

    public T getiData() {
        return iData;
    }

    public void setiData(T iData) {
        this.iData = iData;
    }

    public GNode<T> getNext() {
        return next;
    }

    public void setNext(GNode<T> next) {
        this.next = next;
    }

    public GNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(GNode<T> previous) {
        this.previous = previous;
    }

// -------------------------------------------------------------
    public void displayLink() // display ourself
    {
        System.out.print("{" + iData + "} ");
    }

}
