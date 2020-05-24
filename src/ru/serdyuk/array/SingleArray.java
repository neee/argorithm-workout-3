package ru.serdyuk.array;

import java.util.Arrays;

public class SingleArray<T> implements Array<T> {

    private Object[] array;

    public SingleArray () {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public void add(T item, int index) {
        Object[] newArray = new Object[array.length + 1];
        if (index == 0) {
            System.arraycopy(array, 0, newArray, 1, array.length);
        } else if (index == array.length) {
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        else {
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index + 1 , array.length - index);
        }
        newArray[index] = item;
        array = newArray;
    }

    @Override
    public T remove(int index) {
        T o = (T) array[index];
        Object[] newArray = new Object[array.length - 1];
        if (index == 0) {
            System.arraycopy(array, 1, newArray, 0, array.length - 1);
        } else if (index == array.length -1) {
            System.arraycopy(array, 0, newArray, 0, array.length - 1);
        } else {
            System.arraycopy(array, 0, newArray, 0, index + 1);
            System.arraycopy(array, index + 1, newArray, index , array.length - index - 1);
        }
        array = newArray;
        return o;
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
