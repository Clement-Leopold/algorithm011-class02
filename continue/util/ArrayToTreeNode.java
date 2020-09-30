package util;

import linkList.ListNode;
import tree.TreeNode;

import java.util.LinkedList;

public class ArrayToTreeNode {

    public static TreeNode arrayToTreeNode(Integer[] array) {
        TreeNode root = null;
        if (array.length == 0) {
            return root;
        }
        root = new TreeNode(array[0]);
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean left = false;
        for (int i = 1; i < array.length; i++) {
            TreeNode p = deque.peekFirst();

            if (!left) {
                if (array[i] != null) {
                    p.left = new TreeNode(array[i]);
                    deque.addLast(p.left);
                }
                left = true;
            } else {
                if (array[i] != null) {
                    p.right = new TreeNode(array[i]);
                    deque.addLast(p.right);
                }
                left = false;
                deque.pollFirst();
            }
        }
        return root;
    }

    public static ListNode arrayToList(int[] array, int index) {
        if (index > array.length - 1) {
            return null;
        }
        int c = array[index];
        ListNode head = new ListNode(c);
        head.next = arrayToList(array, index + 1);
        return head;
    }
}
