package com.example.datastructure.util;

public class MeasureUtils {

    public static void measureExecutionTime(Runnable function) {
        // 开始时间
        long startTime = System.nanoTime();

        // 执行函数
        function.run();

        // 结束时间
        long endTime = System.nanoTime();

        // 计算执行时间
        long duration = endTime - startTime;

        // 将执行时间转换为毫秒并打印
        double durationInMillis = duration / 1_000_000.0;
        System.out.println("函数执行时间: " + durationInMillis + " 毫秒");
    }

}
