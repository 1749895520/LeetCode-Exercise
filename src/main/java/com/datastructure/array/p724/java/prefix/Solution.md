# p724 寻找数组的中心位置

---

## 前缀和

### 代码

```java
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
```

### 分析

通过 sumLeft 和 sumRight 两个部分进行比较，不断将 res 下标处的数值从 sumRight 中去除加到 sumLeft 中，直到存在左右两部分和相同或者不存在相同的情况。
