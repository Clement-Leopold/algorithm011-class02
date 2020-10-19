package tree;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, 0, preorder.length - 1, init(inorder));
    }

    private Map<Integer, Integer> init(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return map;
    }

    private TreeNode helper(int[] pre, int idx, int left, int right, Map<Integer, Integer> map) {
        if (left > right || idx > pre.length - 1) return null;
        TreeNode node = new TreeNode(pre[idx]);
        int ri = map.get(node.val);
        node.left = helper(pre, idx + 1, left, ri - 1, map);
        node.right = helper(pre, idx + ri - left + 1, ri + 1, right, map);
        return node;
    }

    public static void main(String[] args) {
        Leetcode105 leetcode105 = new Leetcode105();
        leetcode105.buildTree(new int[] {3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
