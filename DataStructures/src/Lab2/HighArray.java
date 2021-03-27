package Lab2;

/**
 *
 * @author Yusuf Abdullah Abdulwahab s438004167
 */
import java.util.*;
import java.io.*;

public class HighArray {

    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    private final int INITIALSIZE = 2;
    private int size;
    //-----------------------------------------------------------

    public HighArray() // constructor
    {
        a = new long[INITIALSIZE];              // create the array
        nElems = 0;                    // no items yet
        size = INITIALSIZE;

    }

    //-----------------------------------------------------------
    public boolean find(int searchKey) {                              // find specified value
        int j;
        for (j = 0; j < nElems; j++) // for each element,
        {
            if (a[j] == searchKey) // found item?
            {
                return true;                       // exit loop before end
            }
        }

        return false;                   // yes, can't find it

    }  // end find()
    //-----------------------------------------------------------

    public int findAll(long a) {
        int counter = 0;
        for (int i = 0; i < nElems; i++) {
            if (this.a[i] == a) {
                counter++;
            }
        }
        if (counter == 0) {
            return -1;
        } else {
            return counter;
        }
    }

    //-----------------------------------------------------------
    public void insert(long value) // put element into array
    {
        if (size == nElems) {
            size *= 2;
            long[] copy = new long[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        a[nElems] = value;
        //System.out.println(a[nElems]);
        nElems++;

    }

    //-----------------------------------------------------------
    public void insertOrdered(long value) // put element into array
    {
        if (size == nElems) {
            size *= 2;
            long[] copy = new long[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        int j;
        for (j = 0; j < nElems; j++) // find where it goes
        {
            if (a[j] > value) // (linear search)
            {
                break;
            }
        }
        for (int k = nElems; k > j; k--) // move bigger ones up
        {
            a[k] = a[k - 1];
        }
        a[j] = value;                  // insert it
        nElems++;                      // increment size
    }  // end insert()
    //-----------------------------------------------------------

    public void sort() {
        quickSort(0, nElems - 1);
    }

    private void quickSort(int low, int high) {
        int s; // Pivot location

        if (low < high) {
            s = partition(low, high);
            quickSort(low, s - 1);
            quickSort(s + 1, high);
        }
    }

    public void insertOrdered2(long value) // put element into array
    {
        if (size == nElems) {
            size *= 2;
            long[] copy = new long[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        int j = 0;
        while (value > a[j] && j < nElems) {
            j++;
        }
        for (int k = nElems; k > j; k--) // move bigger ones up
        {
            a[k] = a[k - 1];
        }
        a[j] = value;                  // insert it
        nElems++;                      // increment size
    }  // end insert()
    //-----------------------------------------------------------

    public int partition(int low, int high) {
        int s;        // Pivot location
        int m;        // Index into array
        long pivotKey; // Holds value of pivot

        pivotKey = a[low];
        s = low;

        for (m = s + 1; m <= high; m++) {
            if (a[m] < pivotKey) {
                swap(++s, m);
            }
        }
        swap(low, s);
        return s;
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) // look for it
        {
            if (value == a[j]) {
                break;
            }
        }
        if (j == nElems) // can't find it
        {
            return false;
        } else // found it
        {
            for (int k = j; k < nElems; k++) // move higher ones down
            {
                a[k] = a[k + 1];
            }
            nElems--;                   // decrement size
            if (nElems == (size / 2)) {
                size /= 2;
                long[] copy = new long[size];
                for (int i = 0; i < nElems; i++) {
                    copy[i] = a[i];
                }
                a = copy;
            }
            return true;
        }

    }  // end delete()
    //-----------------------------------------------------------

    public boolean deleteAll(long value) {
        boolean condition = false;
        for (int i = 0; i < nElems; i++) {
            while (a[i] == value) {
                for (int j = i; j < nElems; j++) {
                    a[j] = a[j + 1];
                }
                nElems--;
                condition = true;
            }
            if (nElems == (size / 2)) {
                size /= 2;
                long[] copy = new long[size];
                for (int f = 0; f < nElems; f++) {
                    copy[f] = a[f];
                }
                a = copy;
            }
        }
        return condition;
    }

    //-----------------------------------------------------------
    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
        {
            System.out.print(a[j] + " ");  // display it
        }
        System.out.println("");
    }

    //-----------------------------------------------------------
    public int binarySearch2(int searchKey) {
        int left = 0, right = nElems - 1;
        int counter = 0;

        while (left <= right) {
            counter++;
            int pivot = (left + right) / 2;
            System.out.println("Pass" + counter + " lowerBound=" + left + " upperBound=" + right + " middleIndex=" + pivot);
            if (a[pivot] == searchKey) {
                return pivot;       // found
            } else {
                if (a[pivot] < searchKey) {
                    left = pivot + 1;  // search right
                } else {
                    right = pivot - 1;  // search left
                }
            }
        }
        return -1;
    }

    //-----------------------------------------------------------
    public int binarySearch(int searchKey) {
        int left = 0;
        int right = nElems - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (a[pivot] == searchKey) {
                return pivot;       // found
            } else {
                if (a[pivot] < searchKey) {
                    left = pivot + 1;  // search right
                } else {
                    right = pivot - 1;  // search left
                }
            }
        }
        return -1;
    }

    public int binarySearch3(int key) {
        int left = 0;
        int right = nElems - 1;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (a[pivot] == key) {
                return pivot;
            }
            if (key > a[pivot]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;

    }

    public int binarySearchRec(int key) {
        return binarySearchRec(key, 0, nElems - 1);
    }

    public int binarySearchRec(long key, int left, int right) {
        int pivot = (left + right) / 2;
        if (a[pivot] == key) {
            return pivot;
        }
        if (left <= right) {
            if (key > a[pivot]) {
                return binarySearchRec(key, pivot + 1, right);
            } else {
                return binarySearchRec(key, left, pivot - 1);
            }
        }
        return -1;
    }

    //-----------------------------------------------------------
    public int size() {
        return nElems;
    }
    //-----------------------------------------------------------

    public void readIntFile(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextInt()) {
            int a = input.nextInt();
            insert(a);
        }
    }
    //-----------------------------------------------------------

    public void bubbleSort() {
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = 0; j < nElems - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    //-----------------------------------------------------------
    public void selectionSort() {
        int minIndex;
        for (int i = 0; i < nElems; i++) {
            minIndex = i;
            for (int j = i + 1; j < nElems; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    public void selectionSortRec(int low) {
        if (low < nElems) {
            int min = low;
            for (int i = low + 1; i < nElems; i++) {
                if (a[i] < a[min]) {
                    min = i;
                }
            }
            swap(min, low);
            selectionSortRec(++low);
        }
    }

    public void selectionSortRec() {
        selectionSortRec(0);
    }
    //-----------------------------------------------------------

    public void insertionSort() {
        for (int i = 1; i < nElems; i++) {
            long key = a[i];
            int j = i - 1;
            while (j > -1 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public void insertionSort1() {
        for (int i = 1; i < nElems; i++) {
            int key = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[key] < a[j]) {
                    swap(key, j);
                    key = j;
                }else{
                    break;
                }
            }
        }
    }

    //--------------------Assignment2---------------------------
    //-1---------------------------------------------------------
    public void addFirst(long value) {
        if (size == nElems) {
            size *= 2;
            long[] copy = new long[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        shiftR(0);
        a[0] = value;

    }

    //-2---------------------------------------------------------
    public long removeFirst() {
        long t = a[0];
        shiftL(0);
        if (nElems == (size / 2) && size != 2) {
            size /= 2;
            long[] copy = new long[size];
            for (int f = 0; f < nElems; f++) {
                copy[f] = a[f];
            }
            a = copy;
        }
        return t;
    }

    //-3---------------------------------------------------------
    public void addAt(int index, long value) {
        if (size == nElems) {
            size *= 2;
            long[] copy = new long[size];
            for (int i = 0; i < nElems; i++) {
                copy[i] = a[i];
            }
            a = copy;
        }
        if (index > nElems) {
            System.out.println("Unvalid index");
        } else {
            shiftR(index);
            a[index] = value;
        }
    }

    //-4---------------------------------------------------------
    public long removeAt(int index) {
        if (index >= nElems) {
            System.out.println("Unvalid index");
        } else {
            long t = a[index];
            shiftL(index);
            if (nElems == (size / 2) && size != 2) {
                size /= 2;
                long[] copy = new long[size];
                for (int f = 0; f < nElems; f++) {
                    copy[f] = a[f];
                }
                a = copy;
            }
            return t;
        }
        return -1;
    }

    //-5--------------------------------------------------------
    public long[] toArray() {
        long[] array = new long[nElems];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.a[i];
        }
        return array;
    }

    //-6--------------------------------------------------------
    public void removeDuplicates() {
        long temp;
        //for (int i = 0; i < nElems; i++) {
        //    temp = a[i];
        //    deleteAll(a[i]);
        //   addFirst(temp);
        //}

        for (int i = 0; i < nElems; i++) {

            for (int j = i + 1; j < nElems; j++) {
                while (a[i] == a[j]) {
                    for (int k = j; k < nElems; k++) {
                        a[i] = a[i + 1];
                    }
                    nElems--;
                }
                if (nElems == (size / 2)) {
                    size /= 2;
                    long[] copy = new long[size];
                    for (int f = 0; f < nElems; f++) {
                        copy[f] = a[f];
                    }
                    a = copy;
                }
            }
        }
    }

    //-7--------------------------------------------------------
    public void set(int index, long value) {
        if (index <= nElems) {
            shiftR(index);
            a[index] = value;
        } else {
            System.out.println("Unvalid index");
        }

    }

    //-8--------------------------------------------------------
    public long get(int index) {
        if (index < size && index > -1) {
            return a[index];
        } else {
            return -1;
        }
    }

    //-9--------------------------------------------------------
    public void clear() {
        nElems = 0;

        size = 2;
        a = new long[size];

    }

    //----------------------------------------------------------
    public void shiftR(int index) {
        /*nElems++;
        long first = a[index];
        long t;
        for (int i = index; i < nElems; i++) {
            t = first;
            first = a[i + 1];
            a[i + 1] = t;*/

        for (int i = nElems; i > index; i--) {
            a[i] = a[i - 1];
        }
        nElems++;
    }

    //-----------------------------------------------------------
    public void shiftL(int index) {
        for (int i = index; i < nElems - 1; i++) {
            a[i] = a[i + 1];
        }
        nElems--;
    }

    //----------------------------------------------------------
    public void swap(long[] arr, int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void swap(int a, int b) {
        long temp = this.a[a];
        this.a[a] = this.a[b];
        this.a[b] = temp;
    }
}
