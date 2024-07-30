package com.example.datastructure.leetcode;

import java.util.HashMap;

public class LeetCode2976 {
    private HashMap<Character, Integer> matrixMap;
    private char[] original;
    private char[] changed;
    private int[] cost;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        if (source.equals(target)) return 0;
        matrixMap = new HashMap<>();
        this.original = original;
        this.changed = changed;
        this.cost = cost;

        recordCharString(source);
        recordCharString(target);
        recordCharMap(original);
        recordCharMap(changed);

        int mapSize = matrixMap.size();
        long[][] costMatrix = new long[mapSize][mapSize];
        initMatrixValue(costMatrix);
        fillMatrixValue(costMatrix);

        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }
            int originalIndex = matrixMap.get(source.charAt(i));
            int changedIndex = matrixMap.get(target.charAt(i));
            if (costMatrix[originalIndex][changedIndex] == Integer.MAX_VALUE) {
                return -1;
            }
            result += costMatrix[originalIndex][changedIndex];
        }
        return result;
    }

    private void fillMatrixValue(long[][] matrix) {
        // 先把original->changed的cost初始化
        for (int i = 0; i < original.length; i++) {
            char originalChar = original[i];
            int originalMatrixIndex = matrixMap.get(originalChar);
            char changedChar = changed[i];
            int changedMatrixIndex = matrixMap.get(changedChar);
            // 这个题最尼玛恶心的地方在这里，它给映射尼玛有重复的卧槽尼玛
            matrix[originalMatrixIndex][changedMatrixIndex] = Math.min(cost[i], matrix[originalMatrixIndex][changedMatrixIndex]);
        }
        // 再查找可行路径
        for (int i = 0; i < original.length; i++) {
            char originalChar = original[i];
            int originalMatrixIndex = matrixMap.get(originalChar);
            char changedChar = changed[i];
            int changedMatrixIndex = matrixMap.get(changedChar);
            findMatrixRoute(matrix, originalMatrixIndex, changedMatrixIndex);
        }
    }

    private void findMatrixRoute(long[][] matrix, int originalIndex, int changedIndex) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[changedIndex][i] == Integer.MAX_VALUE || matrix[changedIndex][i] == 0) {
                continue;
            }
            long value = matrix[originalIndex][changedIndex] + matrix[changedIndex][i];
            if (value < matrix[originalIndex][i]) {
                matrix[originalIndex][i] = value;
                findMatrixRoute(matrix, originalIndex, i);
            }
        }
    }

    private void initMatrixValue(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    private void recordCharMap(char[] charArr) {
        int startIndex = matrixMap.size();
        for (char c : charArr) {
            if (matrixMap.get(c) == null) {
                matrixMap.put(c, startIndex++);
            }
        }
    }

    private void recordCharString(String value) {
        int startIndex = matrixMap.size();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (matrixMap.get(c) == null) {
                matrixMap.put(c, startIndex++);
            }
        }
    }
}
