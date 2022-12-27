# p695 岛屿的最大面积
---

## dfs搜索

### 代码

```java
public class Solution {
    private int size = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxSize = Math.max(maxSize, size);
                    size = 0;
                }
            }
        }
        return maxSize;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (grid[i][j] == 0) return;
        size++;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

### 分析

这题的大体思路和 200. 岛屿数量 完全一样，只不过 dfs 函数淹没岛屿的同时，还应该想办法记录这个岛屿的面积。
