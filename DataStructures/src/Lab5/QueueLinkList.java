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
public class QueueLinkList {

    protected LinkList queueLinkList;

    public QueueLinkList() {
        this.queueLinkList = new LinkList();
    }

    public void enqueue(Node n) {
        this.queueLinkList.insertLast(n.getiData());
    }

    public Node dequeue() {
        return this.queueLinkList.deleteFirst();
    }
}
