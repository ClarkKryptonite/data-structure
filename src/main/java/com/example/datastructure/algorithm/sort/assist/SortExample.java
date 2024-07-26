package com.example.datastructure.algorithm.sort.assist;

import com.example.datastructure.util.NumberUtils;

import java.util.Arrays;

public class SortExample {
    private final int[] randomArr = NumberUtils.generateRandomNumbers();
    private final int[] randomDuplicateArr = NumberUtils.generateDuplicateNumbers();
    private final int[] randomUniqueArr = NumberUtils.generateUniqueRandomNumbers();

    public SortExample() {
        System.out.println("--- SortExample ---");
        System.out.println("randomArr:" + Arrays.toString(randomArr));
        System.out.println("randomDuplicateArr:" + Arrays.toString(randomDuplicateArr));
        System.out.println("randomUniqueArr:" + Arrays.toString(randomUniqueArr));
        System.out.println();
    }

    private int[] copyRandomArr() {
        return randomArr.clone();
    }

    private int[] copyRandomDuplicateArr() {
        return randomDuplicateArr.clone();
    }

    private int[] copyRandomUniqueArr() {
        return randomUniqueArr.clone();
    }

    public void printSort(ISort sort) {
        System.out.println("--- SortName:" + sort.getClass().getSimpleName() + " ---");
        printDifferentArr(sort, "RandomArr", copyRandomArr());
        printDifferentArr(sort, "DuplicateArr", copyRandomDuplicateArr());
        printDifferentArr(sort, "UniqueArr", copyRandomUniqueArr());
    }

    private void printDifferentArr(ISort sort, String name, int[] arr) {
        sort.sort(arr);
        System.out.println("Sort " + name + ":" + Arrays.toString(arr));
    }
}
