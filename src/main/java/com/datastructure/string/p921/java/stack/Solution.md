# p921 使括号有效的最小添加
---

## 栈

### 代码

```java
public class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0, need = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                need++;
            } else {
                need--;
            }
            if (need == -1) {
                need = 0;
                res++;
            }
        }
        return res + need;
    }
}
```

### 分析

这段代码就是最终解法，核⼼思路是以左括号为基准，通过维护对右括号的需求数 need，来计算最⼩的插⼊
次数。需要注意两个地⽅：

1、当 need == -1 的时候意味着什么？
因为只有遇到右括号 ) 的时候才会 need--，need == -1 意味着右括号太多了，所以需要插⼊左括号。
⽐如说 s = "))" 这种情况，需要插⼊ 2 个左括号，使得 s 变成 "()()"，才是⼀个有效括号串。

2、算法为什么返回 res + need？
因为 res 记录的左括号的插⼊次数，need 记录了右括号的需求，当 for 循环结束后，若 need 不为 0，那么
就意味着右括号还不够，需要插⼊。
⽐如说 s = "))(" 这种情况，插⼊ 2 个左括号之后，还要再插⼊ 1 个右括号，使得 s 变成 "()()()"，才
是⼀个有效括号串。
