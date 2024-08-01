package com.example.datastructure.leetcode;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

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
