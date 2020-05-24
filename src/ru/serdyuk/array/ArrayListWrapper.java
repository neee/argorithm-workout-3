package ru.serdyuk.array;

import java.util.ArrayList;

public class ArrayListWrapper<T> implements Array<T> {

    private final ArrayList<T> list;

    public ArrayListWrapper() {
        this.list = new ArrayList<T>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void add(T item, int index) {
        list.add(index, item);
    }

    @Override
    public T remove(int index) {
        return list.remove(index);
    }
}
