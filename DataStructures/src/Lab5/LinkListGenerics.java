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
public class LinkListGenerics<T extends Comparable> {

    private GNode<T> first;
    private int length;

    public LinkListGenerics() {
        this.first = null;
        this.length = 0;
    }

    public GNode<T> getFirst() {
        return first;
    }

    public void setFirst(GNode<T> first) {
        this.first = first;
    }

    public int length() {
        return length;
    }

    public void plusLength() {
        length++;
    }

    public void minusLength() {
        length--;
    }

    public boolean isEmpty() {
        return (getFirst() == null);
    }

    public void insertFirst(T dd) {
        GNode<T> newLink = new GNode<>(dd);
        newLink.setNext(getFirst());
        setFirst(newLink);
        plusLength();
    }

    public void insertLast(T dd) {
        if (!isEmpty()) {
            GNode<T> newLink = new GNode<>(dd);
            GNode<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newLink);
        } else {
            first = new GNode(dd);
        }
        plusLength();
    }

    public void displayList() {
        if (!isEmpty()) {
            GNode<T> current = getFirst();
            for (int i = 0; i < length(); i++) {
                current.displayLink();
                current = current.getNext();
            }
            System.out.println("");
        }
    }

    public GNode<T> deleteFirst() {
        if (!isEmpty()) {
            GNode<T> temp = first;
            first = first.getNext();
            temp.setNext(null);
            minusLength();
            return temp;
        } else {
            return null;
        }
    }

    public T deleteLast() {
        if (!isEmpty()) {
            GNode<T> current = first;
            GNode<T> prev = first;
            GNode<T> temp = null;
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }
            temp = current;
            prev.setNext(null);
            minusLength();
            return temp.getiData();
        } else {
            return null;
        }
    }

    public GNode<T> find(T key) {
        GNode<T> current = first;
        while (current != null) {
            if (current.getiData().equals(key)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    public GNode<T> findRec(T key){
        return findRec(key,getFirst());
    }
    public GNode<T> findRec(T key,GNode current){
        if(current != null){
            if(current.getiData().equals(key)){
                return current;
            }else{
                current = current.getNext();
                return findRec(key, current);
            }
        }else{
            return null;
        }
    }

    public GNode<T> delete(T key) {
        GNode<T> x = find(key);
        if (x == null) {
            return null;
        }
        if (x == getFirst()) {
            return deleteFirst();
        }
        GNode<T> prev = null;
        GNode<T> current = first;

        while (current != null) {
            if (current.getiData().equals(key)) {
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

    public int indexOf(GNode<T> n) {
        GNode<T> current = getFirst();
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

    public int indexOf(T n) {
        GNode<T> current = getFirst();
        int counter = 0;
        for (int i = 0; i < length(); i++) {
            if (current.getiData().equals(n)) {
                return counter;
            }
            counter++;
            current = current.getNext();
        }

        return -1;
    }

    @Override
    public String toString() {
        String s = "";
        GNode<T> current = getFirst();
        for (int i = 0; i < length(); i++) {
            s+= current.getiData();
            current = current.getNext();
        }
        return s;
    }

}
