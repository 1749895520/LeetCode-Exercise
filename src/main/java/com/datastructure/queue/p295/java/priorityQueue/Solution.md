# p295 数据流的中位数
---

## 双指针

### 代码

```java
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
```

### 分析

略。
