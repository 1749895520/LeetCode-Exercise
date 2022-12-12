package com.datastructure.array.p48.java.common;

import org.junit.Test;

public class TestSolution {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        for (int[] rows : matrix) {
            for (int row : rows) {
                System.out.print(row + " ");
            }
            System.out.println();
        }

    }
}
