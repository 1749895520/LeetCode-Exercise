# p20 有效的括号
---

## 栈

### 代码

```java
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (!stack.empty() && stack.peek() == getLeft(c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    private Character getLeft(char c) {
        return c == ')' ? '(' : c == '}' ? '{' : '[';
    }
}
```

### 分析

遇到左括号就⼊栈，遇到右括号就去栈中寻找最近的左括号，看是否匹配
