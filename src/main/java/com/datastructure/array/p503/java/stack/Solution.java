package com.datastructure.array.p503.java.stack;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }
}
