/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
import java.util.Scanner;

/**
 * Test hash table algorithm
 *
 */
public class HashTableTest {

    private HashTableLinear theHashTable;
    //private HashTableChaining theHashTable;

    /**
     * Default constructor
     */
    public HashTableTest() {
        theHashTable = new HashTableLinear();
        //theHashTable = new HashTableChaining();

        theHashTable.insert(new DataItem("1", "aiden"));
        theHashTable.insert(new DataItem("2", "tom"));
        theHashTable.insert(new DataItem("3", "fred"));
        theHashTable.insert(new DataItem("4", "kieran"));

        theHashTable.print();
    }

    /**
     * Display menu
     */
    public void menu() {
        DataItem aDataItem;
        String key;
        String info;
        Scanner Console = new Scanner(System.in);
        while (true) {
            System.out.print("(p)rint (i)nsert (d)elete (f)ind (q)uit: ");
            char choice = Console.nextLine().charAt(0);
            switch (choice) {
                case 'p':
                    theHashTable.print();
                    break;

                case 'i':
                    System.out.print("Enter key value: ");
                    key = Console.nextLine();
                    System.out.print("Enter info value: ");
                    info = Console.nextLine();
                    aDataItem = new DataItem(key, info);
                    theHashTable.insert(aDataItem);
                    break;

                case 'd':
                    System.out.print("Enter key value to delete: ");
                    key = Console.nextLine();
                    DataItem d = theHashTable.delete(key);
                    if (d == null) {
                        System.out.println("Not Deleted..");
                    }
                    break;

                case 'f':
                    System.out.print("Enter key value to find: ");
                    key = Console.nextLine();
                    aDataItem = theHashTable.find(key);

                    if (aDataItem != null) {
                        System.out.println("Found " + aDataItem);
                    } else {
                        System.out.println("Could not find " + key);
                    }
                    break;

                case 'q':
                    return;

                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }

    public static void main(String[] args) {
        HashTableTest test = new HashTableTest();

        test.menu();
    }
}
