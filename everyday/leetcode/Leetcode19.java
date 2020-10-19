package leetcode;

import linkList.ListNode;

public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode node = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode aux = prev;
        for (int start = 0; start < n; start++) cur = cur.next;
        while (cur != null) {
            prev = prev.next;
            node = node.next;
            cur = cur.next;
        }
        prev.next = node.next;
        return aux.next;
    }
}
