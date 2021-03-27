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
public class CircularDoubleLinkedGenerics<T extends Comparable> extends LinkListGenerics<T> {

    private GNode<T> last;

    public CircularDoubleLinkedGenerics() {
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
    public void insertFirst(T x) {
        GNode<T> newNode = new GNode<>(x);
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
    public GNode<T> deleteFirst() {
        if (!isEmpty()) {
            if (getLast() == getFirst()) {
                GNode<T> temp = getFirst();
                temp.setNext(null);
                temp.setPrevious(null);
                setFirst(null);
                setLast(null);
                minusLength();
                return temp;
            }
            GNode<T> temp = getFirst();

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
    public void insertLast(T x) {
        GNode<T> newNode = new GNode<>(x);
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
    public T deleteLast() {
        if (!isEmpty()) {
            if (getLast() == getFirst()) {
                GNode<T> temp = getLast();
                temp.setNext(null);
                temp.setPrevious(null);
                setFirst(null);
                setLast(null);
                minusLength();
                return temp.getiData();
            }
            GNode<T> temp = getLast();

            setLast(getLast().getPrevious());
            getFirst().setPrevious(getLast());
            getLast().setNext(getFirst());

            temp.setNext(null);
            temp.setPrevious(null);
            minusLength();
            return temp.getiData();

        } else {
            return null;
        }

    }

    @Override
    public GNode<T> find(T a) {
        GNode<T> current = getFirst();
        for (int i = 0; i < length(); i++) {
            if (current.getiData().equals(a)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public GNode<T> findRec(T a) {
        return findRec(getFirst(), a);
    }

    public GNode<T> findRec(GNode current, T a) {
        if (current.getNext() == getFirst()) {
            if (current.getiData().equals(a)) {
                return current;
            } else {
                return null;
            }
        } else {
            if (current.getiData().equals(a)) {
                return current;
            } else {
                current = current.getNext();
                return findRec(current, a);
            }
        }
    }

    public T findMaxRec() {
        return findMaxRec(getFirst(), getFirst().getiData());
    }

    public T findMaxRec(GNode current, T max) {
        if (current.getNext() == getFirst()) {
            if (max.compareTo(current.getiData()) < 0) {
                max = (T) current.getiData();
                return max;
            } else {                
                return max;
            }
        } else {
            if (max.compareTo(current.getiData()) < 0) {
                max = (T) current.getiData();
                current = current.getNext();
                return findMaxRec(current, max);
            } else {
                current = current.getNext();
                return findMaxRec(current, max);
            }
        }
    }
    public T findMinRec() {
        return findMinRec(getFirst(), getFirst().getiData());
    }

    public T findMinRec(GNode current, T min) {
        if (current.getNext() == getFirst()) {
            if (current.getiData().compareTo(min) < 0) {
                min = (T) current.getiData();
                return min;
            } else {                
                return min;
            }
        } else {
            if (current.getiData().compareTo(min) < 0) {
                min = (T) current.getiData();
                current = current.getNext();
                return findMinRec(current, min);
            } else {
                current = current.getNext();
                return findMinRec(current, min);
            }
        }
    }
    
//find with rec max min--------------------------------------------------------------------------------

    @Override
    public GNode<T> delete(T a) {//كيف احذف الاول والاخير؟
        GNode<T> current = find(a);

        if (current != null) {
            if (current == getFirst()) {
                return deleteFirst();
            }
            if (current == getLast()) {
                return new GNode(deleteLast());
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

    public void update(int index, Object e) throws IndexOutOfBoundsException {
        remove(index);
        insert(index, e);
        /*
        if (!(index >= 0 || index <= length())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(e instanceof GNode)) {
            System.out.println("Wrong data");
            return;
        }
        GNode<T> x = (GNode<T>) e;
        GNode<T> current = getFirst();
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
