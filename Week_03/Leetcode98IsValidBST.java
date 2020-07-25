import tree.TreeNode;

/**
 * 98 验证二叉搜索树
 */
public class Leetcode98IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (upper != null && root.val >= upper) return false;
        if (lower != null && root.val <= lower) return false;
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        isValidBST(root);
    }
}
