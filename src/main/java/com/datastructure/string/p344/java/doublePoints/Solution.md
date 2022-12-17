# p344 反转字符串
---

## 双指针

### 代码

```java
public class Solution {
    public void reverseString(char[] s) {
        int p1 = 0, p2 = s.length - 1;
        while (p1 < p2) {
            char t = s[p1];
            s[p1] = s[p2];
            s[p2] = t;
            p1++;
            p2--;
        }
    }
}
```

### 分析

利用双指针进行计算。
