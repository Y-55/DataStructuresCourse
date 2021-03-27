/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author yoooo
 */
public class Node {

    private int iData;              // data item (key)
    private Node next;              // next link in list
    private Node previous;
// -------------------------------------------------------------

    public Node(int id) // constructor
    {
        iData = id;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    
    
    
// -------------------------------------------------------------

    public void displayLink() // display ourself
    {
        System.out.print("{" + iData + "} ");
    }
    
    
}
