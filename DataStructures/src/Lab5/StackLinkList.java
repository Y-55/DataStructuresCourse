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
public class StackLinkList {

    protected LinkList stackLinkList;

    public StackLinkList() {
        this.stackLinkList = new LinkList();
    }

    public void push(Node n) {
        this.stackLinkList.insertFirst(n.getiData());
    }

    public void push2(Node n) {
        stackLinkList.insertLast(n.getiData());
    }

    public Node pop() {
        return this.stackLinkList.deleteFirst();
    }

    public Node pop2() {
        return stackLinkList.deleteLast();
    }

    public Node peek() {
        return stackLinkList.getFirst();
    }
}
