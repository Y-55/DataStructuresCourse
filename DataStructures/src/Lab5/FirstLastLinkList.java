package Lab5;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class FirstLastLinkList extends LinkList {

    protected Node last;	

    public FirstLastLinkList() {
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
    public void insertFirst(int a) {
        Node newLink = new Node(a);
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
    public void insertLast(int a) {
        Node newLink = new Node(a);
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
    public Node deleteFirst() {
        if (!isEmpty()) {
            Node current = getFirst();
            if (getFirst() == getLast()) {
                setLast(null);
            }
            setFirst(getFirst().getNext());

            current.setNext(null);
            minusLength();
            return current;
        } else {
            return null;
        }
    }

    @Override
    public Node deleteLast() {
        if (!isEmpty()) {
            Node current = getFirst();
            Node prev = null;
            if (getFirst() == getLast()) {
                setFirst(null);
                setLast(null);
                minusLength();
                return current;
            }
            while (current.getNext() != null) {
                prev = current;
                current = current.getNext();
            }

            prev.setNext(null);
            setLast(prev);
            minusLength();
            return current;
        } else {
            return null;
        }
    }

    @Override
    public Node delete(int key) {
        Node x = find(key);
        if (x == null) {
            return null;
        }
        if (x == getFirst()) {
            return deleteFirst();
        }
        if (x == getLast()) {
            return deleteLast();
        }
        Node prev = null;
        Node current = getFirst();

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
            Node prev = null;
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
        Node prev = null;
        while (counter != index) {
            counter++;
            prev = current;
            current = current.getNext();
        }
        prev.setNext(current.getNext());

        current.setNext(null);
        minusLength();
    }

    @Override
    public void update(int index, Object e) throws IndexOutOfBoundsException {
        remove(index);
        insert(index, e);
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
}
