/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import Lab4.*;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class StackQueuePerformance {

    public static void main(String[] arg) {
        int[] a = {100, 1000, 10000, 100000,1000000};
        int counter;

        StackLinkList stack = new StackLinkList();
        QueueLinkList queue = new QueueLinkList();
        StackArray stackA = new StackArray();
        QueueArray queueA = new QueueArray();

        System.out.println("  N       Stack Array     Queu Array     Stack link List    Queue link List");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%-7d", a[i]);
//----------------------------Stack Array-------------------------------------------------------------
            int startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                stackA.push((int) (Math.random() * 100));
                counter++;
            }
            counter = 0;
            while (counter < a[i]) {
                stackA.pop();
                counter++;
            }
            int endtTime = (int) System.currentTimeMillis();
            System.out.printf("        %-7d", (endtTime - startTime));
//----------------------------Queu Array-------------------------------------------------------------
            startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                queueA.enqueue((int) (Math.random() * 100));
                counter++;
            }
            counter = 0;
            while (counter < a[i]) {
                queueA.dequeue();
                counter++;
            }
            endtTime = (int) System.currentTimeMillis();
            System.out.printf("        %-7d", (endtTime - startTime));
//----------------------------Stack link List-------------------------------------------------------------
            startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                Node x = new Node((int) (Math.random() * 100));
                stack.push(x);
                counter++;
            }
            counter = 0;
            while (counter < a[i]) {
                stack.pop();
                counter++;
            }
            endtTime = (int) System.currentTimeMillis();
            System.out.printf("           %-7d", (endtTime - startTime));

//----------------------------Queue link List-------------------------------------------------------------
            startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                Node x = new Node((int) (Math.random() * 100));
                queue.enqueue(x);
                counter++;
            }
            counter = 0;
            while (counter < a[i]) {
                queue.dequeue();
                counter++;
            }
            endtTime = (int) System.currentTimeMillis();
            System.out.printf("            %-7d", (endtTime - startTime));

//--------------------------------------------------------------------------------------------------------
            System.out.println();
        }
    }
}
