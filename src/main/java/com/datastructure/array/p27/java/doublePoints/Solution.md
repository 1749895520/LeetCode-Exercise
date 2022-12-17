# p27 移除元素
---

## 双指针

### 代码

```java
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
```

### 分析

利用双指针进行计算。
