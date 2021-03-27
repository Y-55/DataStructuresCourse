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
public class CircularDoubleLinked extends LinkList {

    private Node last;

    public CircularDoubleLinked() {
        super();
        last = null;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    @Override
    public void insertFirst(int x) {
        Node newNode = new Node(x);
        if (last == null) {
            last = newNode;
            setFirst(newNode);
        }
        getFirst().setPrevious(newNode);
        newNode.setPrevious(last);
        last.setNext(newNode);
        newNode.setNext(getFirst());
        setFirst(newNode);

        plusLength();
    }

    @Override
    public Node deleteFirst() {
        if (!isEmpty()) {
            Node temp = getFirst();

            setFirst(getFirst().getNext());
            getFirst().setPrevious(getLast());
            getLast().setNext(getFirst());

            temp.setNext(null);
            temp.setPrevious(null);
            minusLength();
            return temp;
        } else {
            return null;
        }

    }

    @Override
    public void insertLast(int x) {
        Node newNode = new Node(x);
        if (getFirst() == null) {
            setFirst(newNode);
            setLast(newNode);
        }
        last.setNext(newNode);
        newNode.setNext(getFirst());
        getFirst().setPrevious(newNode);
        newNode.setPrevious(last);
        setLast(newNode);

        plusLength();
    }

    @Override
    public Node deleteLast() {
        if (!isEmpty()) {
            Node temp = getLast();

            setLast(getLast().getPrevious());
            getFirst().setPrevious(getLast());
            getLast().setNext(getFirst());

            temp.setNext(null);
            temp.setPrevious(null);
            minusLength();
            return temp;

        } else {
            return null;
        }

    }

    @Override
    public Node find(int a) {
        Node current = getFirst();
        for (int i = 0; i < length(); i++) {
            if (current.getiData() == a) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public Node delete(int a) {//كيف احذف الاول والاخير؟
        Node current = find(a);

        if (current != null) {
            if (current == getFirst()) {
                return deleteFirst();
            }
            if (current == getLast()) {
                return deleteLast();
            }
            current.getNext().setPrevious(current.getPrevious());
            current.getPrevious().setNext(current.getNext());

            current.setNext(null);
            current.setPrevious(null);
            minusLength();
            return current;
        } else {
            return null;
        }
    }

    @Override
    public void insert(int index, Object e) throws IndexOutOfBoundsException {
        if (!(index <= length() && index > -1)) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        if (!(e instanceof Node)) {
            System.out.println("unvalid data");
        } else {
            Node x = (Node) e;

            if (index == 0) {
                insertFirst(x.getiData());
                return;
            }
            if (index == length()) {
                insertLast(x.getiData());
                return;
            }
            int counter = 0;
            Node current = getFirst();
            while (counter != index) {
                counter++;
                current = current.getNext();
            }
            x.setNext(current);
            x.setPrevious(current.getPrevious());
            current.getPrevious().setNext(x);
            current.setPrevious(x);
            plusLength();
        }

    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (!(index < length() && index > -1)) {
            throw new IndexOutOfBoundsException("wrong index");
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == length() - 1) {
            deleteLast();
            return;
        }
        int counter = 0;
        Node current = getFirst();
        while (counter != index) {
            counter++;
            current = current.getNext();
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());

        current.setNext(null);
        current.setPrevious(null);
        minusLength();
    }

    @Override
    public void update(int index, Object e) throws IndexOutOfBoundsException {
        remove(index);
        insert(index, e);
        /*
        if (!(index >= 0 || index <= length())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(e instanceof Node)) {
            System.out.println("Wrong data");
            return;
        }
        Node x = (Node) e;
        Node current = getFirst();
        if (index == 0) {
            deleteFirst();
            insertFirst(x.getiData());
            return;
        }
        if (index == length() - 1) {
            deleteLast();
            insertLast(x.getiData());
            return;
        }
        int counter = 0;
        while (counter != index) {
            counter++;
            current = current.getNext();
        }
        x.setNext(current.getNext());
        x.setPrevious(current.getPrevious());

        current.getNext().setPrevious(x);
        current.getPrevious().setNext(x);

        current.setNext(null);
        current.setPrevious(null);
         */
    }

    @Override
    public Node retrieve(int index) throws IndexOutOfBoundsException {
        if (!(index < length() && index > -1)) {
            throw new IndexOutOfBoundsException("wrong index");
        }
        int counter = 0;
        Node current = getFirst();
        while (counter != index) {
            counter++;
            current = current.getNext();
        }
        Node temp = new Node(current.getiData());
        return temp;
    }

    @Override
    public void displayList() {
        if (!isEmpty()) {
            Node current = getFirst();
            for (int i = 0; i < length(); i++) {
                current.displayLink();
                current = current.getNext();
            }
        }
    }
}
