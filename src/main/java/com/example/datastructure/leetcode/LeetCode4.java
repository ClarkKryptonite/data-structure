package com.example.datastructure.leetcode;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmpNums = nums1;
            nums1 = nums2;
            nums2 = tmpNums;
        }
        int nums1LeftIndex = 0;
        int nums1RightIndex = nums1.length;
        int totalPartitionIndex = (nums1.length + nums2.length + 1) / 2;

        int maxLeftValue = 0;
        int minRightValue = 0;

        while (nums1LeftIndex <= nums1RightIndex) {
            int partitionA = (nums1LeftIndex + nums1RightIndex) / 2;
            int nums1SmallerValue = getFinalNums(nums1, partitionA - 1);
            int nums1BiggerValue = getFinalNums(nums1, partitionA);

            int partitionB = totalPartitionIndex - partitionA;
            int nums2SmallerValue = getFinalNums(nums2, partitionB - 1);
            int nums2BiggerValue = getFinalNums(nums2, partitionB);

            if (nums1SmallerValue > nums2BiggerValue) {
                nums1RightIndex = partitionA - 1;
            } else if (nums2SmallerValue > nums1BiggerValue) {
                nums1LeftIndex = partitionA + 1;
            } else {
                maxLeftValue = Math.max(nums1SmallerValue, nums2SmallerValue);
                minRightValue = Math.min(nums1BiggerValue, nums2BiggerValue);
                break;
            }
        }

        if (((nums1.length + nums2.length) & 1) == 0) {
            return (maxLeftValue + minRightValue) / 2.0;
        } else {
            return maxLeftValue;
        }
    }


    private int getFinalNums(int[] nums, int partitionIndex) {
        if (partitionIndex < 0) {
            return Integer.MIN_VALUE;
        } else if (partitionIndex >= nums.length) {
            return Integer.MAX_VALUE;
        } else {
            return nums[partitionIndex];
        }
    }


    public double firstSubmission(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int totalLen = nums1Len + nums2Len;
        int totalMidIndex = totalLen / 2;
        int midLeft = 0;
        int midRight = 0;
        int nums1Index = 0;
        int nums2Index = 0;
        for (int i = 0; nums1Index < nums1Len && nums2Index < nums2Len && i <= totalMidIndex; i++) {
            midLeft = midRight;
            if (nums1[nums1Index] < nums2[nums2Index]) {
                midRight = nums1[nums1Index];
                nums1Index++;
            } else {
                midRight = nums2[nums2Index];
                nums2Index++;
            }
        }
        if (nums1Index < nums1Len) {
            int curTotalIndex = nums2Len + nums1Index;
            while (nums1Index < nums1Len && curTotalIndex <= totalMidIndex) {
                midLeft = midRight;
                midRight = nums1[nums1Index++];
                curTotalIndex++;
            }
        }
        if (nums2Index < nums2Len) {
            int curTotalIndex = nums1Len + nums2Index;
            while (nums2Index < nums2Len && curTotalIndex <= totalMidIndex) {
                midLeft = midRight;
                midRight = nums2[nums2Index++];
                curTotalIndex++;
            }
        }

        if (totalLen % 2 == 0) {
            return (double) (midLeft + midRight) / 2;
        } else {
            return midRight;
        }
    }
}
