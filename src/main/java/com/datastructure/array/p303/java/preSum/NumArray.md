# p303 区域和检索 - 数组不可变

---

## 前缀和数组

### 代码

```java
public class NumArray {
    private final int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
```

### 分析

利用前缀和数组直接按照边界求出区间和。
