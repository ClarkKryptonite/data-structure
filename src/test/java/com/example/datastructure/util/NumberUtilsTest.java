package com.example.datastructure.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberUtilsTest {

    @Test
    void generateRandomNumbers() {
        int[] arr = NumberUtils.generateRandomNumbers();
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void testOrderNumbers() {
        int[] arr = NumberUtils.generateRandomNumbers();
        int[] newArr = arr.clone();
        assertArrayEquals(newArr, arr);
    }


}