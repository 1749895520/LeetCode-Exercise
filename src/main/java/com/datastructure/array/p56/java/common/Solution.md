# p56 合并区间

---

## 排序 + lambda

### 代码

```java
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] add = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (add[1] >= intervals[i][0]) {
                add[1] = Math.max(add[1], intervals[i][1]);
            } else {
                res.add(add);
                add = intervals[i];
            }
        }
        res.add(add);
        return res.toArray(new int[0][0]);
    }
}
```

### 分析

通过先根据每个区间的左边界排序（利用lambda），再将所有重合的区间合并为一个区间，最后添加到ArrayList数组中转换为int[][]数组返回。
