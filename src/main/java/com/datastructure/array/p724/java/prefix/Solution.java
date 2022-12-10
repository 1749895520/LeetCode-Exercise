package com.datastructure.array.p724.java.prefix;

public class Solution {
    public int pivotIndex(int[] nums) {
        int res = 0, sumLeft = 0, sumRight = 0;
        for (int i = 1; i < nums.length; i++) {
            sumRight += nums[i];
        }
        while (sumLeft != sumRight) {
            sumLeft += nums[res++];
            if (res >= nums.length) break;
            sumRight -= nums[res];
        }
        return res < nums.length ? res : -1;
    }
}
