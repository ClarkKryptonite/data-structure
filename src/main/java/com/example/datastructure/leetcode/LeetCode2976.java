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
        int[][] costMatrix = new int[mapSize][mapSize];
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

    private void fillMatrixValue(int[][] martix) {
        // 先把original->changed的cost初始化
        for (int i = 0; i < original.length; i++) {
            char originalChar = original[i];
            int originalMatrixIndex = matrixMap.get(originalChar);
            char changedChar = changed[i];
            int changedMatrixIndex = matrixMap.get(changedChar);
            martix[originalMatrixIndex][changedMatrixIndex] = cost[i];
        }
        // 再查找可行路径
        for (int i = 0; i < original.length; i++) {
            char originalChar = original[i];
            int originalMatrixIndex = matrixMap.get(originalChar);
            char changedChar = changed[i];
            int changedMatrixIndex = matrixMap.get(changedChar);
            findMatrixRoute(martix, originalMatrixIndex, changedMatrixIndex);
        }
    }

    private void findMatrixRoute(int[][] matrix, int originalIndex, int changedIndex) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[changedIndex][i] == Integer.MAX_VALUE || matrix[changedIndex][i] == 0) {
                continue;
            }
            int value = matrix[originalIndex][changedIndex] + matrix[changedIndex][i];
            if (value < matrix[originalIndex][i]) {
                matrix[originalIndex][i] = value;
                findMatrixRoute(matrix, changedIndex, i);
            }
        }
    }

    private void initMatrixValue(int[][] matrix) {
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
