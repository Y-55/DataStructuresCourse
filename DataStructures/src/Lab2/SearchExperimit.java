/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

/**
 *
 * @author yoooo
 */
public class SearchExperimit {

    public static void main(String[] a) {
        System.out.println("N      insert      insertOrder     LinearSearch      BinarySearch");
        int n = 500;
        HighArray high;

        while (n < 64000) {
            n = n * 2;
//---insert---------------------------------------------------------------------
            high = new HighArray();
            long timeS = System.nanoTime();
            for (int i = 0; i < n; i++) {
                high.insert((long) (Math.random() * 100));
            }
            long timeE = System.nanoTime();
            System.out.printf("%-5d    %-5d",n , (timeE - timeS) / 1000000);

            System.out.print("    ");
//---insertOrdered--------------------------------------------------------------
            high = new HighArray();
            timeS = System.nanoTime();
            for (int i = 0; i < n; i++) {
                high.insertOrdered((long) (Math.random() * 100));
            }
            timeE = System.nanoTime();
            System.out.printf("     %-5d" , (timeE - timeS) / 1000000);

            System.out.print("    ");
//---linearSearch---------------------------------------------------------------
            timeS = System.nanoTime();
            for (int i = 0; i < n; i++) {
                high.find(-1);
            }
            timeE = System.nanoTime();
            System.out.printf("       %-7d" , (timeE - timeS) / 1000000);

            System.out.print("    ");
//---binarySearch---------------------------------------------------------------

            timeS = System.nanoTime();
            for (int i = 0; i < n; i++) {
                high.binarySearch(-1);
            }
            timeE = System.nanoTime();
            System.out.printf("        %-5d\n", (timeE - timeS) / 1000000);

        }
        System.out.println("------------");

    }

}
