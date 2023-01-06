package com.datastructure.array.p1696.java.monotonicQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int maxResult(int[] nums, int k) {
        int sum = nums[0], step = 0, left = 1, right = 1;
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        while (right < nums.length) {
            while (step > 0) {
                monotonicQueue.pop(left, nums[left++]);
                step--;
            }
            while (monotonicQueue.size() < k && right < nums.length) {
                monotonicQueue.push(right, nums[right++]);
            }
            if (step == 0 || right == nums.length) {
                Integer[] max = monotonicQueue.max();
                step = max[0] - right + k + 1;
                sum += max[1];
            }
        }
        return sum;
    }
}

class MonotonicQueue {
    private Deque<Integer[]> maxQueue = new LinkedList<>();
    private int size = 0;

    public void push(int index, int val) {
        while (!maxQueue.isEmpty() && maxQueue.getLast()[1] < val) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(new Integer[]{index, val});
        size++;
    }

    public void pop(int index, int val) {
        if (Arrays.equals(new Integer[]{index, val}, maxQueue.getFirst())) {
            maxQueue.pollFirst();
        }
        size--;
    }

    public int size() {
        return size;
    }

    public Integer[] max() {
        return maxQueue.getFirst();
    }
}
