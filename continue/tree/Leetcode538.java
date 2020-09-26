package tree;

public class Leetcode538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        convertBST(root.left);
        return root;
    }
}
