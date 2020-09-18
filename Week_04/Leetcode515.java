import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode515 {

    LinkedList<TreeNode> queue = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                max = Math.max(max, node.val);
            }
            ans.add(max);
        }
        return ans;
    }
}
