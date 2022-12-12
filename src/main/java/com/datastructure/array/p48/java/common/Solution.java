package com.datastructure.array.p48.java.common;

public class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j1 = 0, j2 = matrix[0].length - 1; j1 < j2; j1++, j2--) {
                int temp = matrix[i][j1];
                matrix[i][j1] = matrix[i][j2];
                matrix[i][j2] = temp;
            }
        }
    }
}
