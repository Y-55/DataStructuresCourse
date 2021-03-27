/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author yoooo
 */
public class PerformanceTest {

    public static void main(String[] args) {
        PerformanceTest p = new PerformanceTest();
         
        int[] nValues = {100,1000,10000,1000000};
        
        p.linearTest(100000);

        p.quadraticTest(100000);

        p.cubicTest(100000);

        // call methods of object p (PerformanceTest) with
        // various sizes of N and see the performance differences
    }

    public void linearTest(int n) {
        int loopcount = 0;
        double starttime = System.nanoTime();
        System.out.print("O(" + n + ") took.. ");
        for (int i = 0; i < n; i++) {
            loopcount++;
        }
        double endtime = System.nanoTime();
        System.out.println(((endtime - starttime)/1000000) + " MilliSeconds (n1)");

    }

    public void quadraticTest(int n) {
        int loopcount = 0;
        double starttime = System.nanoTime();
        System.out.print("O(" + n + ") took.. ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                loopcount++;
            }
        }
        double endtime = System.nanoTime();
        System.out.println(((endtime - starttime)/1000000) + " MilliSeconds (n2)");

    }

    public void cubicTest(int n) {
        int loopcount = 0;
        double starttime = System.nanoTime();
        System.out.print("O(" + n + ") took.. ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c < n; c++) {
                    loopcount++;
                }
            }
        }
        double endtime = System.nanoTime();
        System.out.println(((endtime - starttime)/1000000) + " MilliSeconds (n3)");

    }

}
