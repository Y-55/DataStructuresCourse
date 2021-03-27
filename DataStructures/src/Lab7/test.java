/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import Lab1.Person;
import Lab5.*;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class test {

    public static void main(String[] arg) {
        HashTableChaining h = new HashTableChaining();

        h.insert(new DataItem("1", "aiden"));
        h.insert(new DataItem("2", "tom"));
        h.insert(new DataItem("3", "fred"));
        h.insert(new DataItem("4", "kieran"));
        h.insert(new DataItem("12", "kieran"));
        h.insert(new DataItem("55", "kieran"));

        h.print();

        HashTableChainingPerson h1 = new HashTableChainingPerson();

        System.out.println("\n");
        h1.insert(new Person("aiden", "1"));
        h1.insert(new Person("tom", "2"));
        h1.insert(new Person("fred", "3"));
        h1.insert(new Person("kieran", "4"));
        h1.insert(new Person("kieran", "12"));
        h1.insert(new Person("kieran", "55"));
        
         
        System.out.println(h1.delete("5"));
             
        
        
        h1.print();
    }
}
