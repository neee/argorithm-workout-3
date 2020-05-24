package ru.serdyuk.array;

import java.util.Arrays;

public class FactorArray<T> implements Array<T> {

    private Object[] array;
    private int factor;
    private int size;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
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
        if (index == 0) {
            System.arraycopy(array, 1, array, 0, size - 1);
        } else if (index == size - 1) {
            array[index] = null;
        } else {
            System.arraycopy(array, 0, array, 0, index - 1);
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
        }
        size--;
        return o;
    }

    private void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
