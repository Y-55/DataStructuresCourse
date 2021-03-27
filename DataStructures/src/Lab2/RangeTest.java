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
public class RangeTest {

    public static void main(String[] a) {
        int n;
        System.out.println("  N            Time   ");
        n = 500;
        while (n < 64000) {
            n = n * 2;
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) Math.random() * 5000;
            }
            System.out.print(n + "  ");
            range1(array);
            for (int i = 0; i < array.length; i++) {

            }
        }
        System.out.println("\n");

        System.out.println("  N            Time   ");
        n = 500;
        while (n < 64000) {
            n = n * 2;
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) Math.random() * 5000;
            }
            System.out.print(n + "  ");
            range2(array);
            for (int i = 0; i < array.length; i++) {

            }
        }
        System.out.println("\n");

        System.out.println("  N            Time   ");
        n = 500;
        while (n < 64000) {
            n = n * 2;
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) Math.random() * 5000;
            }
            System.out.print(n + "  ");
            range3(array);
            for (int i = 0; i < array.length; i++) {

            }
        }
        System.out.println("\n");
    }

    public static int range1(int[] numbers) {
        double starttime = System.nanoTime();
        int diff = 0;
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                diff = Math.abs(numbers[i] - numbers[j]);

                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        double endtime = System.nanoTime();
        System.out.println(((endtime - starttime)/1000000) + " MilliSeconds (n)");
        return diff;
    }

    public static int range2(int[] numbers) {
        double starttime = System.nanoTime();
        int diff = 0;
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                diff = Math.abs(numbers[i] - numbers[j]);

                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        double endtime = System.nanoTime();
        System.out.println(((endtime - starttime)/1000000) + " MilliSeconds (n)");
        return diff;
    }

    public static int range3(int[] numbers) {
        double starttime = System.nanoTime();
        int max = numbers[0];     // find max/min values
        int min = max;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        double endtime = System.nanoTime();
        System.out.println(((endtime - starttime)/1000000) + " MilliSeconds (n)");
        return max - min;
    }

}
