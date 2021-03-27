package BonusQuestionsQ1;

import java.util.Scanner;

/**
 *
 * @author Yusuf Abdulwahab
 */
public class App {

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        Database database = new Database();
        int[][] x = {
            {2,3},
            {4,5}
        };

        System.out.println("Welcome to the IdiotBank Account Management System!\n");
        boolean qout = true;
        while (qout) {
            char requset = input.next().charAt(0);
            switch (requset) {
                case 'a':
                    String name = input.next();
                    double balance = input.nextDouble();
                    if (!database.add(name, balance)) {
                        System.out.println("database full");
                    }
                    break;
                case 'r':
                    name = input.next();
                    if (!database.remove(name)) {
                        System.out.println("not found");
                    }
                    break;
                case 's':
                    name = input.next();
                    if (database.search(name) == null) {
                        System.out.println("not found");
                    } else {
                        database.search(name).toString();
                    }
                    break;
                case 'd':
                    database.dump();
                    break;
                case 't':
                    System.out.println(database.total());
                    break;
                case 'q':
                    qout = false;
            }
        }
    }
}
