/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ6;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class NthFibonacci {

    public static void main(String[] args) {
        System.out.println(Fibonacci(12));
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
