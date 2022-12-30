package com.datastructure.array.p496.java.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[len1];
        int[] greater = getGreater(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map.put(nums2[i], greater[i]);
        }
        for (int i = 0; i < len1; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    private int[] getGreater(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
