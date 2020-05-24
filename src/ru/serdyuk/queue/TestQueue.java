package ru.serdyuk.queue;

import java.util.stream.IntStream;

public class TestQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3);
        IntStream.range(0, 3)
            .forEach(p -> {
                if (p == 0) {
                    priorityQueue.offer(1, p);
                    priorityQueue.offer(2, p);
                } else if (p == 1) {
                    priorityQueue.offer(3, p);
                    priorityQueue.offer(4, p);
                    priorityQueue.offer(5, p);
                } else if (p == 2) {
                    priorityQueue.offer(6, p);
                    priorityQueue.offer(7, p);
                    priorityQueue.offer(8, p);
                    priorityQueue.offer(9, p);
                }
            });
        System.out.println(priorityQueue);

        while (true) {
            Integer value = priorityQueue.poll();
            if (value == null) {
                break;
            }
            System.out.println(value);
        }
    }
}
