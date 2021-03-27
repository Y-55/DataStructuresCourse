/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 * @param <T>
 */
public class FirstLastLinkListGenerics<T extends Comparable> extends LinkListGenerics<T> {
    protected GNode<T> last;	

    public FirstLastLinkListGenerics() {
        super();
        last = null;
    }

    public GNode<T> getLast() {
        return last;
    }

    public void setLast(GNode<T> last) {
        this.last = last;
    }

    @Override
    public void insertFirst(T a) {
        GNode<T> newLink = new GNode<>(a);
        if (!isEmpty()) {
            newLink.setNext(getFirst());
            setFirst(newLink);
        } else {
            setFirst(newLink);
            setLast(newLink);
        }
        plusLength();
    }

    @Override
    public void insertLast(T a) {
        GNode<T> newLink = new GNode<>(a);
        if (!isEmpty()) {
            getLast().setNext(newLink);
            setLast(newLink);
        } else {
            setFirst(newLink);
            setLast(newLink);
        }

        plusLength();
    }

    @Override
    public GNode<T> deleteFirst() {
        if (!isEmpty()) {
            GNode<T> current = getFirst();
            if (getFirst() == getLast()) {
                setLast(null);
            }
            setFirst(getFirst().getNext());

            current.setNext(null);
            return current;
        } else {
            return null;
        }
    }

    @Override
    public T deleteLast() {
        if (!isEmpty()) {
            GNode<T> current = getFirst();
            GNode<T> prev = null;
            if (getFirst() == getLast()) {
                setFirst(null);
                setLast(null);
                minusLength();
                return current.getiData();
            }
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }
            prev.setNext(null);
            setLast(prev);
            minusLength();
            return current.getiData();
        } else {
            return null;
        }
    }

    @Override
    public GNode<T> delete(T key) {
        GNode<T> x = find(key);
        if (x == null) {
            return null;
        }
        if (x == getFirst()) {
            return deleteFirst();
        }
        if (x == getLast()) {
            return new GNode(deleteLast());
        }
        GNode<T> prev = null;
        GNode<T> current = getFirst();

        while (current != null) {
            if (current.getiData() == key) {
                prev.setNext(current.getNext());
                current.setNext(null);

                minusLength();
                return current;
            }
            prev = current;
            current = current.getNext();

        }
        return null;
    }

    
    public void insert(int index, Object e) throws IndexOutOfBoundsException {
        if (!(index <= length() && index > -1)) {
            throw new IndexOutOfBoundsException("Wrong index");
        }
        if (!(e instanceof GNode)) {
            System.out.println("unvalid data");
        } else {
            GNode<T> x = (GNode<T>) e;

            if (index == 0) {
                insertFirst(x.getiData());
                return;
            }
            if (index == length()) {
                insertLast(x.getiData());
                return;
            }
            int counter = 0;
            GNode<T> current = getFirst();
            GNode<T> prev = null;
            while (counter != index) {
                counter++;
                prev = current;
                current = current.getNext();
            }
            prev.setNext(x);
            x.setNext(current);
            plusLength();
        }

    }

    
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
        GNode<T> current = getFirst();
        GNode<T> prev = null;
        while (counter != index) {
            counter++;
            prev = current;
            current = current.getNext();
        }
        prev.setNext(current.getNext());

        current.setNext(null);
        minusLength();
    }

    
    public void update(int index, Object e) throws IndexOutOfBoundsException {
        remove(index);
        insert(index, e);
    }

    

    public GNode<T> retrieve(int index) throws IndexOutOfBoundsException {
        if (!(index < length() && index > -1)) {
            throw new IndexOutOfBoundsException("wrong index");
        }
        int counter = 0;
        GNode<T> current = getFirst();
        while (counter != index) {
            counter++;
            current = current.getNext();
        }
        GNode<T> temp = new GNode<>(current.getiData());
        return temp;
    }
}
