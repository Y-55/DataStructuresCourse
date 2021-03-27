/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class ArrayExpanderRunner
{
   public static void main(String[] args)
   {
      ArrayExpander ae = new ArrayExpander();
      System.out.println(ae);
      ae.add("a");
      ae.add("b");
      System.out.println(ae);
      ae.add("c");
      ae.add("d");  
      ae.add("e");
      System.out.println(ae);
      ae.add("f");
      ae.add("g");
      ae.add("h");  
      System.out.println(ae);
      ae.add("i");
      System.out.println(ae);
   }
}

