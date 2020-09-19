package foundmental;

import linkList.ListNode;

public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            head = head.next;
        }
        return head;
    }
}
