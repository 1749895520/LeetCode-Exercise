# p26 删除有序数组中的重复项
---

## 双指针

### 代码

```java
public class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0, p2 = 1;
        for (; p2 < nums.length; p2++) {
            if (nums[p1] != nums[p2]) {
                nums[++p1] = nums[p2];
            }
        }
        return p1 + 1;
    }
}
```

### 分析

利用双指针进行计算。
