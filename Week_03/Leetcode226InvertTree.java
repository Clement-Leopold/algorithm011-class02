import tree.TreeNode;

public class Leetcode226InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        invert(root.left);
        invert(root.right);
    }


}
