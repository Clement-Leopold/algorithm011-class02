import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode144BinaryTreePreorderTraversal {

    /**
     * 递归遍历
     *
     * @param root 根节点
     * @return 先序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    /**
     * 迭代遍历
     *
     * @param root 根节点
     * @return 先序遍历
     */
    public List<Integer> preorderTraversalInteration(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                ans.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
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
