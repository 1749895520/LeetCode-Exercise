# p503 下一个更大元素 II
---

## 单调队列

### 代码

```java
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue<Integer> monotonicQueue = new MonotonicQueue<>();
        int len = nums.length - k + 1;
        int[] res = new int[len];
        for (int i = 0; i < k - 1; i++) {
            monotonicQueue.push(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            monotonicQueue.push(nums[i]);
            res[i - k + 1] = monotonicQueue.max();
            monotonicQueue.pop();
        }
        return res;
    }
}
class MonotonicQueue<E extends Comparable<E>> {
    private final LinkedList<E> maxQueue;
    private final LinkedList<E> minQueue;
    private final Queue<E> allQueue;

    public MonotonicQueue() {
        maxQueue = new LinkedList<>();
        minQueue = new LinkedList<>();
        allQueue = new LinkedList<>();
    }

    // 在队尾添加元素 n
    public void push(E n) {
        // 将 maxQueue 前面小于 n 的元素都删除
        while (!maxQueue.isEmpty() && maxQueue.getLast().compareTo(n) < 0) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(n);
        // 将 minQueue 前面大于 n 的元素都删除
        while (!minQueue.isEmpty() && minQueue.getLast().compareTo(n) > 0) {
            minQueue.pollLast();
        }
        minQueue.addLast(n);
        // 将 n 添加到 allQueue 中
        allQueue.add(n);
    }

    // 弹出队头元素
    public E pop() {
        E n = allQueue.poll();
        if (n == maxQueue.getFirst()) {
            maxQueue.pollFirst();
        }
        if (n == minQueue.getFirst()) {
            minQueue.pollFirst();
        }
        return n;
    }

    // 返回队列大小
    public int size() {
        return allQueue.size();
    }

    // 返回当前队列中的最⼤值
    public E max() {
        return maxQueue.getFirst();
    }

    // 返回队列中的最小值
    public E min() {
        return minQueue.getFirst();
    }
}
```

### 分析

使用单调队列的思想完成。
