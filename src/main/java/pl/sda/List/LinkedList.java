package pl.sda.List;

public class LinkedList<T> implements IList<T> {
    Node first;
    Node last;
    int size = 0;


    @Override
    public boolean isEmpty() {
        if (size > 0)
            return false;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkBounds(index);

        Node tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return (T) tmp.getValue();
    }

    @Override
    public void set(int index, T value) {
        checkBounds(index);
        Node tmp = first;

        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        tmp.setValue(value);
    }

    @Override
    public void remove(int index) {
        checkInsertBounds(index);
        Node tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        if (index == 0) {
            first = tmp.getNext();
            first.setPrev(null);
            tmp.setNext(null);
        } else if (index == size - 1) {
            last = tmp.getPrev();
            last.setNext(null);
            tmp.setPrev(null);
        } else {
            tmp.getNext().setPrev(tmp.getPrev());
            tmp.getPrev().setNext(tmp.getNext());
        }
        size--;
    }

    @Override
    public int firstIndexWith(T value) {
        int index = 0;
        Node tmp = first;
        while (tmp != null) {
            if (tmp.getValue().equals(value)) {
                return index;
            }
            index++;
            tmp = tmp.getNext();
        }
        return -1;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            last = first = new Node(value);
        } else {
            Node next = new Node(value);
            last.setNext(next);
            next.setPrev(last);
            last = next;
        }
        size++;
    }

    @Override
    public void add(int index, T value) {
        checkInsertBounds(index);
        if (size == 0 || index == size) {
            add(value);
            return;
        }

        Node tmpPrev = first;
        for (int i = 0; i < index; i++) {
            tmpPrev = tmpPrev.getNext();
        }

        insertBetween(tmpPrev, value);
    }

    private void insertBetween(Node replaced, T value) {
        Node newNode = new Node(value);

        Node beforeReplaced = replaced.getPrev();

        //No node before replaced this means that replaced was first node!
        //Now 'first' must point to the newNode we inserted
        if (beforeReplaced == null) {
            first = newNode;
        } else {
            beforeReplaced.setNext(newNode);
            newNode.setPrev(beforeReplaced);
        }
        newNode.setNext(replaced);
        replaced.setPrev(newNode);

        size++;
    }

    @SuppressWarnings("Uncheck")
    @Override
    public T[] getHolderView() {

        T[] tab = (T[]) new Object[size];
        int index = 0;
        Node tmp = first;
        while (tmp != null) {
            tab[index++] = (T) tmp.getValue();
            tmp = tmp.getNext();
        }
        return tab;
    }

    //When retrieving value last element is at index size -1
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    //when inserting value you can add it between other or exactly at the end which is index = size
    private void checkInsertBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }
}
