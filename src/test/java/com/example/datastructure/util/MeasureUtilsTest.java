package com.example.datastructure.util;

import org.junit.jupiter.api.Test;

class MeasureUtilsTest {

    @Test
    void measureExecutionTime() {
        MeasureUtils.measureExecutionTime(() -> {
            for (int i = 0; i < 1000000; i++) {
                // 模拟计算任务
                Math.sqrt(i);
            }
        });
    }
}