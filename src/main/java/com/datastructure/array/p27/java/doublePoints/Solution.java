package com.datastructure.array.p27.java.doublePoints;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = 0;
        for (; p2 < nums.length; p2++) {
            if (nums[p2] != val) {
                nums[p1++] = nums[p2];
            }
        }
        return p1;
    }
}
