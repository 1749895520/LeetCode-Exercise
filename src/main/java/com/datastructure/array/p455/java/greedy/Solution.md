# p455 分发饼干
---

## 贪心算法

### 代码

```java
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int children = 0, cookies = 0;
        while (cookies < s.length && children < g.length) {
            if (g[children] <= s[cookies++]) children++;
        }
        return children;
    }
}
```

### 分析

这里的贪心策略是，给剩余孩子里最小饥饿度的孩子分配最小的能饱腹的饼干。
至于具体实现，因为我们需要获得大小关系，一个便捷的方法就是把孩子和饼干分别排序。
这样我们就可以从饥饿度最小的孩子和大小最小的饼干出发，计算有多少个对子可以满足条件。
