package com.example.datastructure.algorithm.sort.assist;

import com.example.datastructure.util.MeasureUtils;
import com.example.datastructure.util.NumberUtils;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class SortExample {
    private final int[][] testCaseArr = new int[][]{
            NumberUtils.generateRandomNumbers(),
            NumberUtils.generateDuplicateNumbers(),
            NumberUtils.generateUniqueRandomNumbers()
    };

    public SortExample() {
        System.out.println("--- SortExample ---");
        for (int i = 0; i < testCaseArr.length; i++) {
            System.out.println("testCase " + i + ":" + Arrays.toString(testCaseArr[i]));
        }
        System.out.println();
    }

    public void printSort(ISort sort, BiConsumer<int[], int[]> callback) {
        System.out.println("--- SortName:" + sort.getClass().getSimpleName() + " ---");
        for (int[] testCase : testCaseArr) {
            printDifferentArr(sort, testCase, callback);
        }
    }

    private void printDifferentArr(ISort sort, int[] arr, BiConsumer<int[], int[]> callback) {
        int[] cloneArr = arr.clone();
        MeasureUtils.measureExecutionTime(() -> sort.sort(cloneArr));
        System.out.println("sort result:" + Arrays.toString(cloneArr));
        callback.accept(arr.clone(), cloneArr);
    }
}
