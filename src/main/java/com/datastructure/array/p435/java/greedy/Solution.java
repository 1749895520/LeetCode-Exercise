package com.datastructure.array.p435.java.greedy;

import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int right = intervals[0][1], remove = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
                remove++;
            } else {
                right = intervals[i][1];
            }
        }
        return remove;
    }
}
