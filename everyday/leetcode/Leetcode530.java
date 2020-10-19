package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode530 {

    int res = Integer.MAX_VALUE;
    int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre == -1) pre = root.val;
        else {
            res = Math.min(res, Math.abs(pre - root.val));
            pre = root.val;
        }
        helper(root.right);
    }

}
