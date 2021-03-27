package Lab1;

/**
 *
 * @author Yusuf Abdullah Abdulwahab 438004167
 */
public class TestPerson {

    public static void main(String[] args) {

        Person p1 = new Person("Yusuf", 21, 1.78);
        Person p2 = new Person();
        p2 = p1;
        System.out.println(p1);
        System.out.println(p2);
        p2.setName("ikyutjhrgbdfv");
        System.out.println(p2);
        System.out.println(p1);
        
        

    }//main

}//class TestPerson
