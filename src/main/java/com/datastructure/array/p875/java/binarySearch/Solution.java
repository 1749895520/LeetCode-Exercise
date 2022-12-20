package com.datastructure.array.p875.java.binarySearch;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = (int) (1e9 + 1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (charge(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int charge(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / speed;
            if (pile % speed != 0) hours++;
        }
        return hours;
    }
}
