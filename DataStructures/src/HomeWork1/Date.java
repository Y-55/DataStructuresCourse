package HomeWork1;

/**
 *
 * @author Yusuf Abdullah Abdulwahab 438004167
 */
public class Date {

    int day;
    int month;
    int year;

    public Date(int a, int b, int c) {
        this.day = a;
        this.month = b;
        this.year = c;
    }//Date

    public Date() {
        day = 1;
        month = 1;
        year = 1;
    }//Date

    public int getDay() {
        return day;
    }//getDay

    public void setDay(int day) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day < 32 && day > 0) {
                    this.day = day;
                } else {
                    System.out.println("Wrong day entered , the day will set to 1");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day < 31 && day > 0) {
                    this.day = day;
                } else {
                    System.out.println("Wrong day entered , the day will set to 1");
                }
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    if (day < 30 && day > 0) {
                        this.day = day;
                    } else {
                        System.out.println("Wrong day entered , the day will set to 1");
                    }
                    break;
                } else {
                    if (day < 29 && day > 0) {
                        this.day = day;
                    } else {
                        System.out.println("Wrong day entered , the day will set to 1");
                    }
                    break;
                }
            default:
                System.out.println("Wrong month entered , the day will set to 1");
        }
    }//setDay

    public int getMonth() {
        return month;
    }//getMonth

    public void setMonth(int m) {
        if (m < 13 && m > 0) {
            this.month = m;
        } else {
            System.out.println("Wrong month entered ,the month will set to 1");
        }
    }//setMonth

    public int getYear() {
        return year;
    }//getYear

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            System.out.println("Wrong year entered ,the year will set to 1");
        }
    }//setYear

    @Override
    public String toString() {
        String s = "";
        s += day + " \\ " + month + " \\ " + year;
        return s;
    }//toString

    public void addDays(int a) {
        int reminder = a + day;
        boolean stop = true;
        while (stop) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (reminder < 32) {
                        stop = false;
                        day = reminder;
                        break;
                    }
                    reminder -= 31;
                    month++;
                    if (month == 13) {
                        month = 1;
                        year++;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (reminder < 31) {
                        stop = false;
                        day = reminder;
                        break;
                    }
                    reminder -= 30;
                    month++;
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        if (reminder < 30) {
                            stop = false;
                            day = reminder;
                            break;
                        }
                        reminder -= 29;
                    } else {
                        if (reminder < 29) {
                            stop = false;
                            day = reminder;
                            break;
                        }
                        reminder -= 28;
                    }
                    month++;
            }
        }
    }//addDays

}
