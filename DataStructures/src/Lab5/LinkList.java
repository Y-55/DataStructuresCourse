/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class LinkList {

    private Node first;            // ref to first item on list
    private int size;              // 

// -------------// -------------------------------------------------------------
    public LinkList() // constructor
    {
        first = null;
        size = 0;
    }           // no items on list yet
// -------------------------------------------------------------

    public Node getFirst() // get value of first
    {
        return first;
    }
// -------------------------------------------------------------

    public void setFirst(Node f) // set first to new link
    {
        first = f;
    }
// -------------------------------------------------------------

    public boolean isEmpty() // true if list is empty
    {
        return (first == null);
    }

    public int length() {
        return size;
    }

    public void plusLength() {
        size++;
    }

    public void minusLength() {
        size--;
    }

// -------------------------------------------------------------
    public void insertFirst(int dd) {
        Node newLink = new Node(dd);
        newLink.setNext(first);
        first = newLink;
        size++;
    }
    // -------------------------------------------------------------

    public void insertLast(int dd) // insert at start of list
    {                           // make new link
        if (first != null) {
            Node newLink = new Node(dd);
            Node current = first;
            while (current.getNext() != null) {
                current = current.getNext();

            }
            current.setNext(newLink);
        } else {
            first = new Node(dd);
        }
        size++;

    }// end insertLast
// -------------------------------------------------------------

    public Node deleteFirst() // delete first item
    {                           // (assumes list not empty)
        if (!isEmpty()) {
            Node temp = first;          // save reference to link
            first = first.getNext();         // delete it: first-->old next
            temp.setNext(null);
            size--;
            return temp;
        } // return deleted link
        else {
            return null;
        }
    }
// -------------------------------------------------------------

    public Node deleteLast() {
        if (!isEmpty()) {
            Node current = first;
            Node prev = first;
            Node temp = null;
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }// end while
            temp = current;
            prev.setNext(null);
            size--;
            return temp;
        } else {
            return null;
        }
    }// end deleteLast
// -------------------------------------------------------------

// -------------------------------------------------------------
    public void displayList() {
        Node current = first;       // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink();   // print data
            current = current.getNext();  // move to next link
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    public Node find(int key) {
        Node current = first;
        while (current != null) {
            if (current.getiData() == key) {
                return current;
            }//if
            current = current.getNext();

        }// while
        return null;
    }
// -------------------------------------------------------------

    public Node delete(int key) {
        Node x = find(key);
        if (x == null) {
            return null;
        }
        if (x == getFirst()) {
            return deleteFirst();
        }
        Node prev = null;
        Node current = first;

        while (current != null) {
            if (current.getiData() == key) {
                prev.setNext(current.getNext());
                current.setNext(null);
                current = null;
                size--;
                return current;
            }//if
            prev = current;
            current = current.getNext();

        }// while
        return null;
    }
// -------------------------------------------------------------

    public void insert(int index, Object e) throws IndexOutOfBoundsException {
        if (index <= length() && index > -1) {
            if (!(e instanceof Node)) {
                System.out.println("unvalid data");
            } else {
                Node x = (Node) e;
                int counter = 0;
                Node current = getFirst();
                Node prev = null;

                while (index != counter) {
                    counter++;
                    prev = current;
                    current = current.getNext();
                }
                x.setNext(current);
                if (prev != null) {
                    prev.setNext(x);
                } else {
                    setFirst(x);
                }
                size++;
            }
        } else {
            throw new IndexOutOfBoundsException("Wrong index");
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < length() && index > -1) {
            int counter = 0;
            Node current = getFirst();
            Node prev = null;

            while (index != counter) {
                counter++;
                prev = current;
                current = current.getNext();
            }
            if (prev != null) {
                prev.setNext(current.getNext());
                current.setNext(null);
                current = null;
            } else {
                deleteFirst();
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException("Wrong index");
        }

    }

    public void update(int index, Object e) throws IndexOutOfBoundsException {
        remove(index);
        insert(index, e);
        /*
        if (index < length() && index > -1) {
            if (!(e instanceof Node)) {
                System.out.println("unvalid data");
            } else {
                Node x = (Node) e;
                int counter = 0;
                Node current = getFirst();
                Node prev = null;
                while (counter != index) {
                    counter++;
                    prev = current;
                    current = current.getNext();
                }
                if (prev != null) {
                    prev.setNext(x);
                    x.setNext(current.getNext());
                    current.setNext(null);
                    current = null;
                } else {
                    deleteFirst();
                    insertFirst(x.getiData());

                }
            }
        } else {
            throw new IndexOutOfBoundsException("Wrong index");
        }
         */
    }

    public Node retrieve(int index) throws IndexOutOfBoundsException {
        if (index < size && index > -1) {
            Node current = getFirst();
            int counter = 0;

            while (counter != index) {
                counter++;
                current = current.getNext();
            }
            Node temp = new Node(current.getiData());
            return temp;
        } else {
            throw new IndexOutOfBoundsException("Wrong index");
        }
    }

    public int indexOf(Node n) {
        Node current = getFirst();
        int counter = 0;
        for (int i = 0; i < length(); i++) {
            if (current.getiData() == n.getiData()) {
                return counter;
            }
            counter++;
            current = current.getNext();
        }

        return -1;
    }

    public ListIterator getIterator() // return iterator
    {
        return new ListIterator(this);  // initialized with
    }                               //    this list

}
