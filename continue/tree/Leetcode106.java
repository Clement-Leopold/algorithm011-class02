package tree;

import java.util.HashMap;
import java.util.Map;

public class Leetcode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursive(postorder, postorder.length - 1, 0, inorder.length - 1, init(inorder));
    }

    private Map<Integer, Integer> init(int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return inorderMap;
    }

    private TreeNode recursive(int[] post, int idx, int left, int right, Map<Integer, Integer> map) {
        if (left > right || idx < 0) return null;
        TreeNode node = new TreeNode(post[idx]);
        int ri = map.get(node.val);
        node.right = recursive(post, idx - 1, ri + 1, right, map);
        node.left = recursive(post, idx - (right - ri) - 1, left, ri - 1, map);
        return node;
    }

    public static void main(String[] args) {
        Leetcode106 leetcode106 = new Leetcode106();
        leetcode106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
