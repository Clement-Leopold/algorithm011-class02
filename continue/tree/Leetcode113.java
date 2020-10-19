package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode113 {

    List<List<Integer>> array = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recursive(root, sum, new LinkedList<>());
        return array;
    }

    private void recursive(TreeNode root, int sum, List<Integer> temp) {
        if (root == null) return;
        temp.add(root.val);
        if (root.right == null && root.left == null && root.val == sum) {
            array.add(new ArrayList<>(temp));
        } else {
            recursive(root.left, sum - root.val, temp);
            recursive(root.right, sum - root.val, temp);
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Leetcode113 leetcode113 = new Leetcode113();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        leetcode113.pathSum(node, 22);
    }
}
