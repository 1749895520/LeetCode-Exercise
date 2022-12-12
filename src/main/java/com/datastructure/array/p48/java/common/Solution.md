# p48 旋转矩阵

---

## 数学

### 代码

```java
public class TestSolution {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        for (int[] rows : matrix) {
            for (int row : rows) {
                System.out.print(row + " ");
            }
            System.out.println();
        }

    }
}
```

### 分析

先将整个矩阵按照主对角线翻转，再将矩阵按照行翻转即可。
