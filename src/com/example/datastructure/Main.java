package com.example.datastructure;

import com.example.datastructure.util.MeasureUtils;
import com.example.datastructure.util.NumberUtils;
import com.example.datastructure.util.StringUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- StringUtils ---");
        System.out.println(StringUtils.generateRandomString());
        System.out.println(Arrays.toString(StringUtils.generateRandomStringArr()));
        System.out.println(StringUtils.generateRandomName());
        System.out.println(Arrays.toString(StringUtils.generateRandomNameArr()));
        System.out.println();
        System.out.println("--- NumberUtils ---");
        System.out.println(Arrays.toString(NumberUtils.generateRandomNumbers()));
        System.out.println(Arrays.toString(NumberUtils.generateUniqueRandomNumbers()));
        System.out.println();
        System.out.println("--- MeasureUtils ---");
        MeasureUtils.measureExecutionTime(() -> {
            for (int i = 0; i < 1000000; i++) {
                // 模拟计算任务
                Math.sqrt(i);
            }
        });
    }
}