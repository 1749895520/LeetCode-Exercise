package com.datastructure.array.p410.java.binarySearch;

public class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = left > num ? left : num;
            right += num;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (charge(nums, mid) <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int charge(int[] nums, int len) {
        int sum = 0, cnt = 1;
        for (int num : nums) {
            if (sum + num > len) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt;
    }
}
