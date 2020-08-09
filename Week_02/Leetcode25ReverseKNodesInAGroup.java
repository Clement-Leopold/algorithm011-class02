public class Leetcode25ReverseKNodesInAGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = calLength(head);
        return reverseKNodes(head, k, length);
    }

    private ListNode reverseKNodes(ListNode head, int k, int length) {
        if (length < k) {
            return head;
        }
        ListNode cur = head;
        int v = k;
        while (v-- > 0) {
            cur = cur.next;
        }
        ListNode nextGroupHead = cur;
        cur = head.next;
        ListNode prev = head;
        while (cur != nextGroupHead) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head.next = reverseKNodes(nextGroupHead, k, length - k);
        return prev;
    }

    private int calLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Leetcode25ReverseKNodesInAGroup leetcode25ReverseKNodesInAGroup = new Leetcode25ReverseKNodesInAGroup();
        leetcode25ReverseKNodesInAGroup.reverseKGroup(head, 2);
    }
}
