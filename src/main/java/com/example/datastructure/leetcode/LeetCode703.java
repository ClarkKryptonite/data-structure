package com.example.datastructure.leetcode;

public class LeetCode703 {
    // 用最大堆表示
    private int[] kthArr;

    public LeetCode703(int k, int[] nums) {
        kthArr = new int[k];
        // 初始化
        for (int i = 0; i < k; i++) {
            kthArr[i] = nums[i];
        }
        // 整理最大堆
        for (int i = k - 1; i >= 0; i--) {
            shiftUp(i);
            shiftDown(i);
        }
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    private void shiftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (kthArr[parentIndex] <= kthArr[index]) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void shiftDown(int index) {
        int value = kthArr[index];
        boolean isMove = false;
        int childIndex = (index + 1) * 2 - 1;
        while (childIndex < kthArr.length) {
            int rightChildIndex = childIndex + 1;
            if (rightChildIndex < kthArr.length && kthArr[rightChildIndex] > kthArr[childIndex]) {
                childIndex = rightChildIndex;
            }
            if (value >= kthArr[childIndex]) {
                break;
            }
            isMove = true;
            kthArr[index] = kthArr[childIndex];
            index = childIndex;
            childIndex = (index + 1) * 2 - 1;
        }
        if (index < kthArr.length && isMove) {
            kthArr[index] = value;
        }

    }

    private void swap(int a, int b) {
        int tmp = kthArr[a];
        kthArr[a] = kthArr[b];
        kthArr[b] = tmp;
    }

    public int add(int val) {
        int topValue = kthArr[0];
        if (val >= topValue) {
            return val;
        }
        kthArr[0] = val;
        shiftDown(0);
        return topValue;
    }
}
