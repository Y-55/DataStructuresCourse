/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author Ysuuf Abdullah Abdulwahab
 */
public class LinkListPerformance {

    public static void main(String[] arg) {

        int[] n = {10, 100, 1000, 10000,100000};
        int counter;

        LinkListGenerics<Integer> l1 = new LinkListGenerics<>();
        FirstLastLinkListGenerics<Integer> l2 = new FirstLastLinkListGenerics<>();
        CircularDoubleLinkedGenerics<Integer> l3 = new CircularDoubleLinkedGenerics<>();

        System.out.println("  N       LinkList     FirstLastLinkList     CircularDoubleLinked");
        for (int i = 0; i < n.length; i++) {
            System.out.printf("%-6d", n[i]);
//------------------------------------------------------------------------------------------
            double startTime = System.currentTimeMillis();
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l1.insertFirst((int) (100 * Math.random()));
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l1.deleteFirst();
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l1.insertLast((int) (100 * Math.random()));
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l1.deleteLast();
            }
            double endTime = System.currentTimeMillis();
            System.out.printf("       %-6d", (long) (endTime - startTime));
//------------------------------------------------------------------------------------------------------
             startTime = System.currentTimeMillis();
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l2.insertFirst((int) (100 * Math.random()));
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l2.deleteFirst();
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l2.insertLast((int) (100 * Math.random()));
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l2.deleteLast();
            }
             endTime = System.currentTimeMillis();
            System.out.printf("           %-6d", (long) (endTime - startTime));
//------------------------------------------------------------------------------------------------------
   startTime = System.currentTimeMillis();
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l3.insertFirst((int) (100 * Math.random()));
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l3.deleteFirst();
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l3.insertLast((int) (100 * Math.random()));
            }
            counter = 0;
            while (counter < n[i]) {
                counter++;
                l3.deleteLast();
            }
             endTime = System.currentTimeMillis();
            System.out.printf("                   %-3d", (long) (endTime - startTime));
//------------------------------------------------------------------------------------------------------
            System.out.println("");
        }
    }

}
