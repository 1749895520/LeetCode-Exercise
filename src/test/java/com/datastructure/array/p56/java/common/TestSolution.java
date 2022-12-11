package com.datastructure.array.p56.java.common;

import org.junit.Test;

public class TestSolution {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1, 4}, {4, 5}};
        int[][] merge = solution.merge(arr);
        for (int[] ints : merge) {
            System.out.println("[" + ints[0] + ", " + ints[1] + "]");
        }
    }
}
