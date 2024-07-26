package com.example.datastructure.algorithm.sort;

import com.example.datastructure.algorithm.sort.assist.ISort;

public class InsertSort implements ISort {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int anchor = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > anchor) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = anchor;
        }
    }
}
