package com.datastructure.array.p56.java.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] add = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (add[1] >= intervals[i][0]) {
                add[1] = Math.max(add[1], intervals[i][1]);
            } else {
                res.add(add);
                add = intervals[i];
            }
        }
        res.add(add);
        return res.toArray(new int[0][0]);
    }
}
