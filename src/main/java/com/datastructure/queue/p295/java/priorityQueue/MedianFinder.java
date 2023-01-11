package com.datastructure.queue.p295.java.priorityQueue;

import java.util.PriorityQueue;

/**
 * @Description MedianFinder
 * @Author ZFiend
 * @Create 2023.01.11 20:42
 */
public class MedianFinder {
    PriorityQueue<Integer> smallQueue;
    PriorityQueue<Integer> largeQueue;

    public MedianFinder() {
        smallQueue = new PriorityQueue<>();
        largeQueue = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (smallQueue.size() >= largeQueue.size()) {
            smallQueue.offer(num);
            largeQueue.offer(smallQueue.poll());
        } else {
            largeQueue.offer(num);
            smallQueue.offer(largeQueue.poll());
        }
    }

    public double findMedian() {
        if (smallQueue.size() > largeQueue.size()) {
            return smallQueue.peek();
        } else if (smallQueue.size() < largeQueue.size()) {
            return largeQueue.peek();
        }
        return (smallQueue.peek() + largeQueue.peek()) / 2.0;
    }
}
