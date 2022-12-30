# p496 下一个更大元素 I
---

## 栈

### 代码

```java
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[len1];
        int[] greater = getGreater(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map.put(nums2[i], greater[i]);
        }
        for (int i = 0; i < len1; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    private int[] getGreater(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
```

### 分析

这就是单调队列解决问题的模板。for 循环要从后往前扫描元素，因为我们借助的是栈的结构，倒着⼊栈，其
实是正着出栈。while 循环是把两个「个⼦⾼」元素之间的元素排除，因为他们的存在没有意义，前⾯挡着个
「更⾼」的元素，所以他们不可能被作为后续进来的元素的下⼀个更⼤元素了。
