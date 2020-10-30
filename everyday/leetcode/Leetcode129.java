package leetcode;

import tree.TreeNode;

/**
 * 根到叶子节点数字之和
 */
public class Leetcode129 {


    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int prev) {
        if (root == null) return prev;
        int value = 10 * prev + root.val;
        if (root.left == null && root.right == null) {
            return value;
        }
        int left = helper(root.left, value);
        int right = helper(root.right, value);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Leetcode129 leetcode129 = new Leetcode129();
        leetcode129.sumNumbers(root);
    }
}
