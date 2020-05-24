package ru.serdyuk.array;

import java.util.Arrays;

public class VectorArray<T> implements Array<T> {

    private Object[] array;
    private int vector;
    private int size;

    public VectorArray(int vector) {
        this.vector = vector;
        array = new Object[0];
        size = 0;
    }

    public VectorArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(T item, int index) {
        if (index == size) {
            add(item);
            return;
        }
        if (size == array.length)
            resize();
        Object[] newArray = new Object[array.length];
        if (index == 0) {
            System.arraycopy(array, 0, newArray, 1, size);
        } else {
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index, size - index);
        }
        newArray[index] = item;
        array = newArray;
        size++;
    }

    @Override
    public T remove(int index) {
        T o = (T) array[index];
        Object[] newArray = new Object[size];
        if (index == 0) {
            System.arraycopy(array, 1, newArray, 0, size - 1);
        } else if (index == size) {
            System.arraycopy(array, 0, newArray, 0, size - 1);
        } else {
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, size - index - 1);
        }
        array = newArray;
        size--;
        return o;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + vector];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
