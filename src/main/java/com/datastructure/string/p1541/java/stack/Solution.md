# p1541 平衡括号字符串的最少插入次数
---

## 栈

### 代码

```java
public class Solution {
    public int minInsertions(String s) {
        int res = 0, need = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) {
                    need--;
                    res++;
                }
            } else {
                need--;
            }
            if (need == -1) {
                need = 1;
                res++;
            }
        }
        return res + need;
    }
}
```

### 分析

通过⼀个 need 变量记录对右括号的需求数，根据 need 的变化来判断是否需要
插⼊。

当 need == -1 时，意味着我们遇到⼀个多余的右括号，显然需要插⼊⼀个左括号。

另外，当遇到左括号时，若对右括号的需求量为奇数，需要插⼊ 1 个右括号。
