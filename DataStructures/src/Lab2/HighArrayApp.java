package Lab2;

/**
 *
 * @author Yusuf Abdullah Abdulwahab s438004167
 */
import Lab1.Person;

public class HighArrayApp {
    
    public static void palendrom(String s){
        System.out.println(s.length());
    }

    public static void main(String[] args) {
        HighArray h = new HighArray();
        h.insert(8);
        h.insert(5);
        h.insert(2);
        h.insert(15);
        h.insert(7);

        h.insertionSort1();
        
        h.display();
        
        //System.out.println(h.binarySearchRec(15));

        //h.partition(0, h.size()-1);
        //h.selectionSortRec();
        //h.selectionSort();
        //h.display();
//        HighArrayString a = new HighArrayString();
//        a.insertOrdered("hi");
//        a.insertOrdered("sd");
//        a.insertOrdered("sd");
//        a.insertOrdered("g");
//        a.insertOrdered("h");
//        a.insertOrdered("a");
//        a.insertOrdered("yusuf");
//        
//        a.display();
//
//        Person p1 = new Person("yusuf");
//        Person p2 = new Person("yaser");
//
//        HighArrayPerson a1 = new HighArrayPerson();
//        a1.insert(p1);
//        a1.insert(new Person("ahmed"));
//        a1.insert(new Person("reda"));
//        a1.insert(p2);
//        a1.insert(new Person("abeed"));
//        a1.insert(new Person("maher"));
//        a1.insert(new Person("eiad"));
//        
//        a1.insertionSort();
//        //a1.display();
//        
//        
//
//        //System.out.println(a1.binarySearch(p2));
//        
//        HighArrayPerson a2 = new HighArrayPerson();
//        try{
//            a2.readIntFile("C:\\Users\\yoooo\\Downloads\\Documents\\DataStructures\\DataStructures\\src\\Lab2\\PersonData.txt");
//            System.out.println(a2.size());
//        }
//        catch(Exception e){
//            
//        }
//        a2.display();
//   
    }
}
