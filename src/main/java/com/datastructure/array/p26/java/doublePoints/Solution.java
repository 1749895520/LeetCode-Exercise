package com.datastructure.array.p26.java.doublePoints;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0, p2 = 1;
        for (; p2 < nums.length; p2++) {
            if (nums[p1] != nums[p2]) {
                nums[++p1] = nums[p2];
            }
        }
        return p1 + 1;
    }
}
