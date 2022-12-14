package com.datastructure.array.p1094.java.differ;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] differ = new int[1005];
        int[] arr = new int[1005];
        int max = 0;
        for (int[] trip : trips) {
            differ[trip[1]] += trip[0];
            differ[trip[2]] -= trip[0];
            max = Math.max(max, trip[2]);
        }
        if (differ[0] > capacity) return false;
        arr[0] = differ[0];
        for (int i = 1; i < max; i++) {
            arr[i] = differ[i] + arr[i - 1];
            if (arr[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
