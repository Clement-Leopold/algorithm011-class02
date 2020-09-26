package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode94 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !linkedList.isEmpty()) {
            while (cur != null) {
                linkedList.push(cur);
                cur = cur.left;
            }
            cur = linkedList.poll();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }


}

