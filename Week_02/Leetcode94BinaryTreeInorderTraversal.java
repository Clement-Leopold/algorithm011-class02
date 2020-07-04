import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode94BinaryTreeInorderTraversal {

    /**
     * 递归
     *
     * @param root 二叉树的根节点
     * @return 答案
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderRecursive(root, ans);
        return ans;
    }

    /**
     * 迭代算法
     *
     * @param root 树的根节点
     * @return 先序遍历
     */
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }

    private void inorderRecursive(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.left, ans);
        ans.add(root.val);
        inorderRecursive(root.right, ans);
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
