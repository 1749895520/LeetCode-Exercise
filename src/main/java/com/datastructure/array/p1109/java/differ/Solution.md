# p1109 航班预订统计
---

## 差分数组

### 代码

```java
public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] differ = new int[n + 1];
        int[] res = new int[n];
        for (int[] booking : bookings) {
            differ[booking[0] - 1] += booking[2];
            differ[booking[1]] -= booking[2];
        }
        res[0] = differ[0];
        for (int i = 1; i < n; i++) {
            res[i] = differ[i] + res[i - 1];
        }
        return res;
    }
}
```

### 分析

利用差分数组将复杂度降低为O(N)。
