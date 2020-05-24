package ru.serdyuk.array;

import java.util.Random;

public class TestArray {

    public static void main(String[] args) {
        SingleArray<Integer> singleArray = new SingleArray<>();
        testArray(singleArray);

        VectorArray<Integer> vectorArray = new VectorArray<>();
        testArray(vectorArray);

        FactorArray<Integer> factorArray = new FactorArray<>();
        testArray(factorArray);

        MatrixArray<Integer> matrixArray = new MatrixArray<>();
        testArray(matrixArray);

        ArrayListWrapper<Integer> arrayListWrapper = new ArrayListWrapper<>();
        testArray(arrayListWrapper);
    }

    private static void testArray(Array array) {
        int minValues = 1000;
        int maxValues = 100000;
        System.out.println("Type: " + array.getClass().getName());

        addLast(array, minValues);
        addLast(array, maxValues);
        removeLast(array);

        addFirst(array, minValues);
        addFirst(array, maxValues);
        removeFirst(array);

        addRandom(array, minValues);
        addRandom(array, maxValues);
        removeRandom(array);
    }

    private static void addLast(Array data, int total) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            data.add(j);
        }
//        System.out.println(data);
        System.out.println("add last: " + total + " time: " + (System.currentTimeMillis() - start));
    }

    private static void removeRandom(Array data) {
        int size = data.size();
        Random random = new Random();
        long start = System.currentTimeMillis();
        while (data.size() > 0) {
            data.remove(random.nextInt(data.size()));
        }
        System.out.println("remove random: " + size + " time:" + (System.currentTimeMillis() - start));
    }

    private static void removeFirst(Array data) {
        int size = data.size();
        long start = System.currentTimeMillis();
        while (data.size() > 0) {
            data.remove(0);
        }
        System.out.println("remove first: " + size + " time:" + (System.currentTimeMillis() - start));
    }

    private static void removeLast(Array data) {
        int size = data.size();
        long start = System.currentTimeMillis();
        while (data.size() > 0) {
            data.remove(data.size() - 1);
        }
        System.out.println("remove last: " + size + " time:" + (System.currentTimeMillis() - start));
    }

    private static void addFirst(Array data, int total) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < total; j++) {
            data.add(j, 0);
        }
        System.out.println("add first: " + total + " time: " + (System.currentTimeMillis() - start));
    }

    private static void addRandom(Array data, int total) {
        Random random = new Random();
        long start = System.currentTimeMillis();
        while (data.size() < total) {
            int item = random.nextInt(data.size() + 1);
            data.add(item, item);
        }
        System.out.println("add random: " + total + " time: " + (System.currentTimeMillis() - start));
    }
}
