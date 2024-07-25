package com.example.datastructure.util;

import java.util.Random;

public class StringUtils {
    private static final int DEFAULT_STRING_LEN = 10;
    private static final int DEFAULT_ARR_LEN = 10;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String[] ARR_NAME = {
            "Alice", "Bob", "Charlie", "David", "Eve",
            "Frank", "Grace", "Hannah", "Ivy", "Jack",
            "Karen", "Leo", "Mona", "Nina", "Oscar",
            "Paul", "Quincy", "Rachel", "Steve", "Tina",
            "Uma", "Victor", "Wendy", "Xander", "Yara",
            "Zach", "Bella", "Carter", "Diana", "Ethan"
    };

    public static String generateRandomString() {
        return generateRandomString(DEFAULT_STRING_LEN);
    }

    public static String generateRandomString(int stringLen) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(stringLen);

        for (int i = 0; i < stringLen; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }

    public static String[] generateRandomStringArr() {
        return generateRandomStringArr(DEFAULT_ARR_LEN);
    }

    public static String[] generateRandomStringArr(int arrLen) {
        String[] arr = new String[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = generateRandomString();
        }
        return arr;
    }

    public static String generateRandomName() {
        Random random = new Random();
        int index = random.nextInt(ARR_NAME.length);
        return ARR_NAME[index];
    }

    public static String[] generateRandomNameArr() {
        return generateRandomNameArr(DEFAULT_ARR_LEN);
    }

    public static String[] generateRandomNameArr(int arrLen) {
        String[] arr = new String[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = generateRandomName();
        }
        return arr;
    }

}
