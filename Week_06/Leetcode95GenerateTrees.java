import java.util.LinkedList;
import java.util.List;

public class Leetcode95GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Leetcode95GenerateTrees leetcode95GenerateTrees = new Leetcode95GenerateTrees();
        leetcode95GenerateTrees.generateTrees(3);
    }
}
