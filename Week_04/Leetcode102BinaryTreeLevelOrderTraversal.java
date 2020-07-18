import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * @author chenxianhao
 */
public class Leetcode102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int index = 0;
        while (!deque.isEmpty()) {
            if (index == ans.size()) {
                ans.add(new ArrayList<>());
            }
            List<Integer> result = ans.get(index);
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.pollFirst();
                size--;
                result.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Leetcode102BinaryTreeLevelOrderTraversal leetcode102BinaryTreeLevelOrderTraversal = new Leetcode102BinaryTreeLevelOrderTraversal();
        leetcode102BinaryTreeLevelOrderTraversal.levelOrder(root);
    }
}
