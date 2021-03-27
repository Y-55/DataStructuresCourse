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
public class TestRecursion {

    public static void main(String[] arg) {
        System.out.println(fact(4));
        test();
    }

    public static long fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void test() {
        System.out.println(".");
        test();
    }
}
