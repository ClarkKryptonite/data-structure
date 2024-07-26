package com.example.datastructure.algorithm.sort;

import com.example.datastructure.algorithm.sort.assist.ISort;

import java.util.Random;

public class QuickSort implements ISort {
    private final Random random = new Random();

    @Override
    public void sort(int[] arr) {
        quickSortArr(arr, 0, arr.length - 1);
    }

    private void quickSortArr(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int index = random.nextInt(startIndex, endIndex + 1);
        swap(arr, index, endIndex);
        int spiltIndex = partition(arr, startIndex, endIndex);
        quickSortArr(arr, 0, spiltIndex - 1);
        quickSortArr(arr, spiltIndex + 1, endIndex);
    }

    private int partition(int[] arr, int startIndex, int endIndex) {
        // 以最后一个元素为锚点
        // 将[startIndex, endIndex]分为小于arr[endIndex]和大于arr[endIndex]的部分
        // 其中arr[partition]左边为小于arr[endIndex]的元素
        // 交换arr[partition]和arr[endIndex]
        // 返回partition
        int leftIndex = startIndex;
        int rightIndex = endIndex - 1;
        int anchor = arr[endIndex];
        while (leftIndex < rightIndex) {
            if (arr[leftIndex] < anchor) {
                leftIndex++;
            } else {
                swap(arr, leftIndex, rightIndex);
                rightIndex--;
            }
        }
        // 有种情况，[startIndex, endIndex)元素都比arr[endIndex]大
        if (arr[leftIndex] > anchor) {
            swap(arr, leftIndex, endIndex);
        }

        return leftIndex;
    }

    private int partitionGpt(int[] arr, int startIndex, int endIndex) {
        // GPT的分隔方法
        // 以最后一个元素为锚点
        // 用一个变量i记录arr[]中左边第一个大于锚点的值左边元素的Index
        // 遍历[startIndex, endIndex)当碰到小于锚点的值时, 将arr[++i]和a[j]交换
        // 最后交换arr[i+1]和锚点的值, 返回i+1
        int anchor = arr[endIndex];
        int i = startIndex - 1;
        for (int j = startIndex; j < endIndex; j++) {
            if (arr[j] < anchor) {
                swap(arr, ++i, j);
            }
        }
        i++;
        swap(arr, i, endIndex);
        return i;
    }

    private void swap(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
