package com.example.datastructure.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberUtils {

    public static final int DEFAULT_ARRAY_SIZE = 10;
    public static final int DEFAULT_MAX_NUMBER = 999;

    public static int[] generateRandomNumbers() {
        return generateRandomNumbers(DEFAULT_ARRAY_SIZE, DEFAULT_MAX_NUMBER);
    }

    public static int[] generateRandomNumbers(int arraySize, int maxNumber) {
        Random random = new Random();
        int[] resultArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            resultArray[i] = random.nextInt(maxNumber + 1);
        }

        return resultArray;
    }

    public static int[] generateUniqueRandomNumbers() {
        return generateUniqueRandomNumbers(DEFAULT_ARRAY_SIZE, DEFAULT_MAX_NUMBER);
    }

    public static int[] generateUniqueRandomNumbers(int arraySize, int maxNumber) {
        if (arraySize > maxNumber + 1) {
            throw new IllegalArgumentException("数组大小不能超过可生成的不重复数字范围");
        }

        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < arraySize) {
            int number = random.nextInt(maxNumber + 1);
            uniqueNumbers.add(number);
        }

        int[] resultArray = new int[arraySize];
        int i = 0;
        for (int number : uniqueNumbers) {
            resultArray[i++] = number;
        }

        return resultArray;
    }
}
