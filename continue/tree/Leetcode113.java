package tree;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> array = new ArrayList<>();
        recursive(root, sum, array, new LinkedList<>());
        return array;
    }

    private void recursive(TreeNode root, int sum, List<List<Integer>> path, LinkedList<Integer> result) {
        if (root == null) return;
        result.addLast(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            path.add(new ArrayList<>(result));
        }
        recursive(root.right, sum - root.val, path, result);
        recursive(root.left, sum - root.val, path, result);
        result.removeLast();
    }
}
