package leetcode;

import lintcode.TreeNode;

/**
 * @author Legend
 * @data by on 21-5-11.
 * @description https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class Test124 {

    int res = -1000;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
