package com.datastructure.array.p239.java.monotonicQueue;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }
}
