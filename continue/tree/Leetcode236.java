package tree;

public class Leetcode236 {

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor(root, p, q);
        return res;
    }

    private boolean ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = ancestor(root.left, p, q);
        boolean right = ancestor(root.right, p, q);
        if ((left && right) ||((left|| right)&& (root.val == p.val || root.val == q.val))){
            res = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }
}
