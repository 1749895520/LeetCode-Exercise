# p141 环形链表
---

## 双指针

### 代码

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p1 = head, p2 = head;
        while (p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) return true;
        }
        return false;
    }

    static class ListNode {
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

利用快慢指针，若没有走到结尾且两指针相遇，则有环。
