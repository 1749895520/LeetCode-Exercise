package com.datastructure.array.p435.java.greedy;

import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test() {
        int[][] arr = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}};
        int i = solution.eraseOverlapIntervals(arr);
        System.out.println(i);
    }
}
