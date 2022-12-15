package com.datastructure.linkedList.p19.java.doublePoints;

public class TestSolution {
    public static void main(String[] args) {
        ListNode.Solution solution = new ListNode.Solution();
        ListNode linkedList = new ListNode();
        ListNode p1 = linkedList;
        int[] arr = new int[]{1, 2};
        for (int i : arr) {
            p1.next = new ListNode(i);
            p1 = p1.next;
        }
        ListNode listNode = solution.removeNthFromEnd(linkedList.next, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
