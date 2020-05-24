package ru.serdyuk.queue;

import java.util.Arrays;

import ru.serdyuk.array.Array;
import ru.serdyuk.array.FactorArray;

public class PriorityQueue<T> {

    private final FactorArray<T>[] queue;

    public PriorityQueue(int priorities) {
        queue = (FactorArray<T>[]) new FactorArray[priorities];
    }

    public T poll() {
        for (Array<T> arr : queue) {
            if (arr != null && arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    return arr.remove(i);
                }
            }
        }
        return null;
    }

    public void offer(T e, int priority) {
        if (priority < queue.length) {
            if (queue[priority] == null) {
                queue[priority] = new FactorArray<>();
            }
            queue[priority].add(e);
        }
    }

    public void offer(T e) {
        offer(e, queue.length - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
