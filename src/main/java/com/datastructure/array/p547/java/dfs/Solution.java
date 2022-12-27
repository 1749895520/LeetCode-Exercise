package com.datastructure.array.p547.java.dfs;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int res = 0;
        int[] citys = new int[m];
        for (int i = 0; i < m; i++) {
            if (citys[i] == 0) {
                res++;
                dfs(isConnected, i, citys);
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int i, int[] citys) {
        int m = isConnected.length;
        citys[i] = 1;
        for (int j = 0; j < m; j++) {
            if (isConnected[i][j] == 1 && citys[j] == 0) {
                dfs(isConnected, j, citys);
            }
        }
    }
}
