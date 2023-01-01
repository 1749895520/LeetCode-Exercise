# p739 每日温度
---

## 栈

### 代码

```java
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
```

### 分析

⽐如说给你输⼊ temperatures = [73,74,75,71,69,76]，你返回 [1,1,3,2,1,0]。因为第⼀天 73
华⽒度，第⼆天 74 华⽒度，⽐ 73 ⼤，所以对于第⼀天，只要等⼀天就能等到⼀个更暖和的⽓温，后⾯的同
理。
这个问题本质上也是找下⼀个更⼤元素，只不过现在不是问你下⼀个更⼤元素的值是多少，⽽是问你当前元
素距离下⼀个更⼤元素的索引距离⽽已。
