package com.example.datastructure.leetcode;

import org.junit.jupiter.api.Test;

class LeetCode2976Test {
    private final LeetCode2976 solution = new LeetCode2976();

    private void testMiniCost(Params params) {
        System.out.println("cost:" + solution.minimumCost(params.source, params.target, params.original, params.changed, params.cost));
    }

    @Test
    void minimumCost() {
        Params params0 = new Params(
                "abcd",
                "acbe",
                new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'},
                new int[]{2, 5, 5, 1, 2, 20}
        );
        Params params1 = new Params(
                "aaaa",
                "bbbb",
                new char[]{'a', 'c'},
                new char[]{'c', 'b'},
                new int[]{1, 2}
        );
        Params params2 = new Params(
                "abcd",
                "abce",
                new char[]{'a'},
                new char[]{'e'},
                new int[]{1000}
        );

        testMiniCost(params0);
        testMiniCost(params1);
        testMiniCost(params2);
    }

    static class Params {
        String source;
        String target;
        char[] original;
        char[] changed;
        int[] cost;

        public Params(String source, String target, char[] original, char[] changed, int[] cost) {
            this.source = source;
            this.target = target;
            this.original = original;
            this.changed = changed;
            this.cost = cost;
        }
    }
}