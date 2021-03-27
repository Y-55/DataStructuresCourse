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
public class LinkList2App {

    public static void main(String[] args) {
        LinkList a = new LinkList(); //new list
        LinkList b = new LinkList(); //new list
        LinkList u = new LinkList();

        Node n1 = new Node(30);

        a.insertFirst(10);
        a.insertLast(20);
        a.insertFirst(10);
        
        a.displayList();

        b.insertFirst(10);
        b.insertLast(30);
        b.insertFirst(10);
        
        b.displayList();
        
        u = ListOpsIter.difference(a, b);
        
        u.displayList();
        

        /*FirstLastLinkList c = new FirstLastLinkList();

        c.insertLast(6);
        c.insertLast(7);
        c.insertLast(8);
        c.insertLast(9);

        

        System.out.println(c.retrieve(1).getiData());
        System.out.println(c.getFirst().getiData());
        System.out.println(c.getLast().getiData());

        c.displayList();*/

        /*CircularDoubleLinkedGenerics<Integer> c = new CircularDoubleLinkedGenerics<>();
        c.insertLast(0);
        c.insertLast(15);
        c.insertLast(2);
        c.insertLast(1);
        c.insertLast(1);
        c.insertLast(16);
        c.insertLast(5);
        
        
        c.displayList();
        
        System.out.println(c.findMinRec());*/
        LinkListGenerics<String> c = new LinkListGenerics<>();
        
        c.insertLast("k");
        c.insertLast("c");
        c.insertLast("1");
//        c.insertLast(1);
//        c.insertLast(1);
//        c.insertLast(16);
//        c.insertLast(5);
        c.displayList();
        
        
       System.out.println(c.findRec("c").getiData());
        
        c.displayList();

    }  // end main()
}  // end class LinkList2App
