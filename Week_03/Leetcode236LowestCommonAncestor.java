public class Leetcode236LowestCommonAncestor {

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        childMatch(root, p, q);
        return ans;
    }

    private boolean childMatch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = childMatch(root.left, p, q);
        boolean right = childMatch(root.right, p, q);
        if ((left && right) || (p.val == root.val || q.val == root.val) && (left || right)) {
            ans = root;
        }
        return left || right || p.val == root.val || q.val == root.val;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
