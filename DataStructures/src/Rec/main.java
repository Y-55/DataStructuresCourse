/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rec;

/**
 *
 * @author yoooo
 */
public class main {

    public static void main(String[] arg) {
        System.out.println(palindromRec("sammas"));
        System.out.println("yusuf".substring(1, 5));
        System.out.println(fictorial(5));
    }

    //palindrom 
    //fib
    //fictorial
    //sum
    //
    public static boolean palindrom(String s) {
        int loop = s.length() / 2;

        for (int i = 0; i < loop; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean palindromRec(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return palindromRec(s.substring(1, s.length() - 1));
    }
    
    public static int fictorial(int n){
        if(n == 1){
            return 1;
        }
        return n*fictorial(n-1);
        
    }
    
    public static void fib(){
        
    }
}
