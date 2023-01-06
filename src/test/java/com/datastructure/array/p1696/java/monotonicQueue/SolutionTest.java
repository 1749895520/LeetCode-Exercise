package com.datastructure.array.p1696.java.monotonicQueue;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
//        int sum = solution.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2);
//        int sum = solution.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3);
        int sum = solution.maxResult(new int[]{-5582, -5317, 6711, -639, 1001, 1845, 1728, -4575, -6066, -7770}, 3);
        System.out.println(sum);
    }
}
