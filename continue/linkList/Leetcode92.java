package linkList;

public class Leetcode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        ListNode node = prev;
        for (int i = m; i <= n; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        node.next.next = cur;
        node.next = prev;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Leetcode92 leetcode92 = new Leetcode92();
        leetcode92.reverseBetween(head, 2, 4);
    }
}
