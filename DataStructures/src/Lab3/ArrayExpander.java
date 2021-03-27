package Lab3;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class ArrayExpander {

    private int size;
    private int noOfItems;
    private String[] store;
    private final int INITIALSIZE = 2;

    public ArrayExpander() {
        store = new String[INITIALSIZE];
        noOfItems = 0;
        size = INITIALSIZE;
    }

    public void add(String x) {
        if(size == noOfItems){
            size *= 2;
            String[] copy = new String[size];
            for(int i = 0;i<noOfItems;i++){
                copy[i] = store[i];
            }
            store = copy;   
        }
        store[noOfItems] = x;
        noOfItems++;
    }

    @Override
    public String toString() {
        String temp = "[" + store[0];
        
        for (int i = 1; i < size; i++) {
            temp = temp + "," + store[i];
        }
        temp = temp + "]";
        return temp;
    }
}
