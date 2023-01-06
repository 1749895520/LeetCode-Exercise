# p316 去除重复元素
---

## 栈

### 代码

```java
public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] isInStack = new boolean[256];
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count[aChar]++;
        }
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]--;
            if (isInStack[chars[i]]) continue;
            while (!stack.isEmpty() && stack.peek() > chars[i]) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                isInStack[stack.pop()] = false;
            }
            stack.push(chars[i]);
            isInStack[chars[i]] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
```

### 分析

要求一、要去重。

要求二、去重字符串中的字符顺序不能打乱 s 中字符出现的相对顺序。

要求三、在所有符合上一条要求的去重字符串中，字典序最小的作为最终结果。

要利用 stack 结构和一个 inStack 布尔数组来满足上述三个条件，具体思路如下：

通过 inStack 这个布尔数组做到栈 stk 中不存在重复元素，满足要求一。

我们顺序遍历字符串 s，通过「栈」这种顺序结构的 push/pop 操作记录结果字符串，保证了字符出现的顺序和 s 中出现的顺序一致，满足要求二。

我们用类似单调栈的思路，配合计数器 count 不断 pop 掉不符合最小字典序的字符，保证了最终得到的结果字典序最小，满足要求三。
