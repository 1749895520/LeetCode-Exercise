package com.datastructure.linkedList.p19.java.doublePoints;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p1 = dummy, p2 = dummy;
            while (n-- > 0) {
                p1 = p1.next;
            }
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p2.next = p2.next.next;
            return dummy.next;
        }
    }
}

