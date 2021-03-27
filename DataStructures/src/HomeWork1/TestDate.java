package HomeWork1;

/**
 *
 * @author Yusuf Abdullah Abdulwahab 438004167
 */
public class TestDate {

    public static void main(String[] args) {
        Date d1 = new Date();

        d1.setYear(2001);
        d1.setMonth(2);
        d1.setDay(29);

        System.out.println("the original date :\n" + d1);
        d1.addDays(2000);
        System.out.println("the date after addetion :\n" + d1);

    }//main

}//TestDate
