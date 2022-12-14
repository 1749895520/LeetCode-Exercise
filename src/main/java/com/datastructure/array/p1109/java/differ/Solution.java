package com.datastructure.array.p1109.java.differ;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] differ = new int[n + 1];
        int[] res = new int[n];
        for (int[] booking : bookings) {
            differ[booking[0] - 1] += booking[2];
            differ[booking[1]] -= booking[2];
        }
        res[0] = differ[0];
        for (int i = 1; i < n; i++) {
            res[i] = differ[i] + res[i - 1];
        }
        return res;
    }
}
