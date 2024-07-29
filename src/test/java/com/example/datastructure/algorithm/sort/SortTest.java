package com.example.datastructure.algorithm.sort;

import com.example.datastructure.algorithm.sort.assist.ISort;
import com.example.datastructure.algorithm.sort.assist.SortExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class SortTest {

    private static final SortExample example = new SortExample();
    private static final BiConsumer<int[], int[]> callback = (arr, sortedArr) -> {
        Arrays.sort(arr);
        Assertions.assertArrayEquals(arr, sortedArr);
    };

    @Test
    void quickSort() {
        ISort sort = new QuickSort();
        example.printSort(sort, callback);
    }

    @Test
    void insertSort() {
        ISort sort = new InsertSort();
        example.printSort(sort, callback);
    }

}
