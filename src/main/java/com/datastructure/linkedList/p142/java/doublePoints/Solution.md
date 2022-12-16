# p142 环形链表 II
---

## 双指针

### 代码

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode p1 = head, p2 = head;
        while (p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                p1 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
```

### 分析

利用快慢指针，若没有走到结尾且两指针相遇，则有环，存在环的情况将其中一个指针从head处和另一个指针一起向前，相遇处则为环起点处。
