package com.example.datastructure.algorithm.sort;

import com.example.datastructure.algorithm.sort.assist.ISort;

import java.util.Random;

public class QuickSort implements ISort {
    private final Random random = new Random();

    @Override
    public void sort(int[] arr) {
        quickSortDuplicateArr(arr, 0, arr.length - 1);
    }

    private void quickSortArr(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int index = random.nextInt(startIndex, endIndex + 1);
        swap(arr, startIndex, index);
        int spiltIndex = partition(arr, startIndex, endIndex);
        quickSortArr(arr, 0, spiltIndex - 1);
        quickSortArr(arr, spiltIndex + 1, endIndex);
    }

    private void quickSortDuplicateArr(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int index = random.nextInt(startIndex, endIndex + 1);
        swap(arr, startIndex, index);
        // 以最后一个元素为锚点anchor=arr[endIndex]
        // 将[startIndex, endIndex]分为小于arr[endIndex]和大于arr[endIndex]的部分
        // 用指针lastSmallerAnchorIndex记录最后一个小于anchor的位置，初始位置为startIndex-1
        // 用指针firstBiggerAnchorIndex记录第一个大于anchor的位置，初始位置为endIndex+1
        // 然后用i遍历[startIndex, firstBiggerAnchorIndex)
        // 如果碰到arr[i]>anchor, 交换arr[i]和arr[--firstBiggerAnchorIndex]
        // 如果碰到arr[i]<anchor, 交换arr[i++]和arr[++lastSmallerAnchorIndex],注意这里i也要变大，因为i的左边为所有<anchor的元素
        // 否则i++
        // 直到i=lastSmallerAnchorIndex
        int anchor = arr[endIndex];
        int lastSmallerAnchorIndex = startIndex - 1;
        int firstBiggerAnchorIndex = endIndex + 1;
        int i = startIndex;
        while (i < firstBiggerAnchorIndex) {
            if (arr[i] < anchor) {
                swap(arr, i++, ++lastSmallerAnchorIndex);
            } else if (arr[i] > anchor) {
                swap(arr, i, --firstBiggerAnchorIndex);
            } else {
                i++;
            }
        }
        quickSortDuplicateArr(arr, 0, lastSmallerAnchorIndex);
        quickSortDuplicateArr(arr, firstBiggerAnchorIndex, endIndex);
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
        swap(arr, ++i, endIndex);
        return i;
    }

    private void swap(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
