package leetcode;

import tree.TreeNode;
import util.ArrayToTreeNode;

public class Leetcode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = ArrayToTreeNode.arrayToTreeNode(new Integer[]{4,2,7,1,3});
        Leetcode701 leetcode701 = new Leetcode701();
        leetcode701.insertIntoBST(node,5);
    }
}
