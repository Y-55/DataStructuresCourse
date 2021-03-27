package Lab1;

/**
 *
 * @author Yusuf Abdullah Abdulwahab 438004167
 */
public class Person implements Comparable {

    protected String name;
    protected int age;
    protected double hight;
    protected String PID;

    public Person() {
        this.name = "";
        this.age = 0;
        this.hight = 0.0;
    }

    public Person(String name, int age, double hight) {
        this.name = name;
        this.age = age;
        this.hight = hight;
    }//Person

    public Person(String name, String i) {
        this.name = name;
        this.PID = i;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getName() {
        return name;
    }//getName

    public void setName(String name) {
        this.name = name;
    }//setName

    public int getAge() {
        return age;
    }//getAge

    public void setAge(int age) {
        if (age > 0 && age < 1450) {
            this.age = age;
        } else {
            System.out.println("wrong age input");
        }
    }//setAge

    public double getHight() {
        return hight;
    }//getHight

    public void setHight(double hight) {
        if (hight > 0 && hight < 4) {
            this.hight = hight;
        } else {
            System.out.println("wrong hight input");
        }
    }//setHight

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("");

        s.append("(Person ID:" + PID + ", ");
        s.append("Person Name:" + name + ")");

        return s.toString();
    }//toString

    @Override
    public boolean equals(Object p) {
        if (!(p instanceof Person)) {
            return false;
        } else {
            Person per = (Person) p;
            return PID.equals(per.PID) || name.equals(per.name); 

        }
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Person)) {
            return -1;
        } else {
            Person other = (Person) obj;
            return name.compareTo(other.name);
        }
    }
}//class Person
