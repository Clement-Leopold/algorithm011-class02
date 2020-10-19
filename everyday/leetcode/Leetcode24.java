package leetcode;

import linkList.ListNode;

public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode nextHead = next.next;
        cur.next = swapPairs(nextHead);
        next.next = cur;
        return next;
    }
}
