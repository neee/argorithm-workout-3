package ru.serdyuk.array;

import java.util.Arrays;

public class MatrixArray<T> implements Array<T> {

    private int size;
    private int vector;
    private Array<T[]> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(100000);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector)
            array.add((T[]) new Object[vector]);
        array.get(size / vector)[size % vector] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector)[index % vector];
    }

    @Override
    public void add(T item, int index) {
        if (size == index) {
            add(item);
            return;
        }
        if (size == array.size() * vector)
            array.add((T[]) new Object[vector]);
        int line = index / vector;
        int pos = index % vector;
        T[] arr = array.get(line);
        T last = arr[arr.length - 1];
        System.arraycopy(arr, pos, arr, pos + 1, arr.length - pos - 1);
        arr[pos] = item;
        size++;
        if (array.size() == line + 1) {
            return;
        }
        for (int i = line + 1; i < array.size(); i++) {
            T[] tempArray = array.get(i);
            T lastInLine = tempArray[vector - 1];
            System.arraycopy(tempArray, 0, tempArray, 1, tempArray.length - 1);
            tempArray[0] = last;
            last = lastInLine;
        }
    }

    @Override
    public T remove(int index) {
        int line = index / vector;
        T[] arr = array.get(line);
        int pos = index % vector;
        T e = arr[pos];
        if (index == size - 1) {
            arr[pos] = null;
            size--;
            return e;
        }
        System.arraycopy(arr, pos + 1, arr, pos, arr.length - pos - 1);
        for (int i = line + 1; i < array.size(); i++) {
            T[] tempArr = array.get(i);
            T firstElement = tempArr[0];
            System.arraycopy(tempArr, 1, tempArr, 0, tempArr.length - 1);
            array.get(i - 1)[vector - 1] = firstElement;
        }
        size--;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            T[] line = array.get(i);
            stringBuilder.append(Arrays.toString(line));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
