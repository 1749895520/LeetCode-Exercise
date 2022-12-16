package com.datastructure.linkedList.p141.java.doublePoints;

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
