package leetcode;

import linkList.ListNode;

public class Leetcode141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode first = head;
        ListNode second = head;

        while (second.next != null) {
            first = first.next;
            second = second.next.next;
            if (second == first) {
                return true;
            }
        }
        return false;
    }
}
