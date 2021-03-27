/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author yusuf Abdullah Abdulwahab
 */
public class StackLinkListPerformance {

    public static void main(String[] arg) {
        int[] a = {100, 1000, 10000, 100000};
        int counter;
        StackLinkList stack = new StackLinkList();

        System.out.println("  N       push     pop     push2     pop2");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%-7d", a[i]);
//----------------------------push-------------------------------------------------------------
            int startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                Node n = new Node((int) (Math.random() * 100));
                stack.push(n);
                counter++;
            }
            int endtTime = (int) System.currentTimeMillis();
            System.out.printf("    %-5d", (endtTime - startTime));
//----------------------------pop---------------------------------------------------------------            
            startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                stack.pop();
                counter++;
            }
            endtTime = (int) System.currentTimeMillis();
            System.out.printf("    %-5d", (endtTime - startTime));
//-----------------------------push2--------------------------------------------------------------
            startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                Node n = new Node((int) (Math.random() * 100));
                stack.push2(n);
                counter++;
            }
            endtTime = (int) System.currentTimeMillis();
            System.out.printf("    %-5d", (endtTime - startTime));
//----------------------------pop2-------------------------------------------------------------
            startTime = (int) System.currentTimeMillis();
            counter = 0;
            while (counter < a[i]) {
                stack.pop2();
                counter++;
            }
            endtTime = (int) System.currentTimeMillis();
            System.out.printf("    %-5d", (endtTime - startTime));
//----------------------------------------------------------------------------------------------
            System.out.println();
        }

    }
}
