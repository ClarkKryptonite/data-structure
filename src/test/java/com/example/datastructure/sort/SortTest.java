package com.example.datastructure.sort;

import com.example.datastructure.algorithm.sort.InsertSort;
import com.example.datastructure.algorithm.sort.QuickSort;
import com.example.datastructure.algorithm.sort.assist.ISort;
import com.example.datastructure.algorithm.sort.assist.SortExample;
import org.junit.jupiter.api.Test;

public class SortTest {

    private static final SortExample example = new SortExample();

    @Test
    void quickSort() {
        ISort sort = new QuickSort();
        example.printSort(sort);
    }

    @Test
    void insertSort() {
        ISort sort = new InsertSort();
        example.printSort(sort);
    }

}
