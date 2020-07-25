import tree.TreeNode;

/**
 * 104 二叉树最大深度
 */
public class Leetcode104MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
