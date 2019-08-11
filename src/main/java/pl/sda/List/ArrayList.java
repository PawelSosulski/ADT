package pl.sda.List;

import java.util.Arrays;

public class ArrayList <T> implements IList<T> {

    private T[] holder;
    private int size = 0;


    public ArrayList() {
        holder =  (T[]) new Object[1];
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return holder[index];
    }

    @Override
    public void set(int index, T value) {
        checkBounds(index);
        holder[index] = value;
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        for (int i = index; i < size - 1; i++) {
            holder[i] = holder[i + 1];
        }
        holder[size - 1] = null;
        size--;
    }

    @Override
    public int firstIndexWith(T value) {
        for (int i = 0; i < size; i++) {
            if (holder[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(int index, T value) {
        if (size == holder.length - 1) {
            T[] holderTmp =  (T[]) new Object[holder.length +1];
            for (int i = 0; i < holder.length; i++) {
                holderTmp[i] = holder[i];
            }
            holder = holderTmp;
        }
        for (int i = size; i > index; i--) {
            holder[i] = holder[i - 1];
        }
        holder[index] = value;
        size++;
    }

    @Override
    public void add(T value) {
        if (size == holder.length - 1) {
            T[] holderTmp =  (T[]) new Object[holder.length +1];
            for (int i = 0; i < holder.length; i++) {
                holderTmp[i] = holder[i];
            }
            holder = holderTmp;
        }
        holder[size] = value;
        size++;
    }

    @Override
    //TODO - This should return copy of the filled part of the array
    public T[] getHolderView() {
        return  Arrays.copyOfRange(holder, 0, size);

    }

    //When retrieving value last element is at index size -1
    private void checkBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    //when inserting value you can add it between other or exactly at the end which is index = size
    private void checkInsertBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

}
