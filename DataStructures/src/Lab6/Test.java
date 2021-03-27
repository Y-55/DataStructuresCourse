/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;



/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class Test {

    public static void main(String[] arg) {
        Tree a = new Tree();
        
        Tree b = new Tree();
        
        b.insert(15);
        b.insert(13);
        b.insert(20);
        b.insert(23);
        b.insert(12);
        b.insert(1);
        b.insert(4);
        b.insert(14);
        b.insert(19);
        b.insert(30);
        b.insert(31);
        b.insert(15);
        b.insert(16);
        
             
       b.inOrder();
        
        System.out.println(b.getNumberOfLevels());
        
       
        
       
      
        
        
        

       

       

        a.insert(15);
        a.insert(13);
        a.insert(20);
        a.insert(23);
        a.insert(12);
        a.insert(1);
        a.insert(4);
        a.insert(14);
        a.insert(19);

        
        

    }
}
