import tree.TreeNode;

import java.util.HashMap;

/**
 * 105 从前序与中序遍历构造二叉树
 */
public class Leetcode105BuildTree {

    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode node = buildChild(preorder, 0, 0, inorder.length);
        return node;
    }

    private TreeNode buildChild(int[] preorder, int preIndex, int inStart, int inEnd) {
        if (preIndex >= preorder.length) {
            return null;
        }
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = inorderMap.get(preorder[preIndex]);
        root.left = buildChild(preorder, preIndex + 1, inStart, rootIndex - 1);
        root.right = buildChild(preorder, preIndex + rootIndex - inStart + 1, rootIndex + 1, inEnd);
        return root;
    }


}
