# p283 移动零
---

## 双指针

### 代码

```java
public class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0, p2 = 0;
        for (; p2 < nums.length; p2++) {
            if (nums[p2] != 0) {
                nums[p1++] = nums[p2];
            }
        }
        for (; p1 < nums.length; p1++) {
            nums[p1] = 0;
        }
    }
}
```

### 分析

利用双指针进行计算。
