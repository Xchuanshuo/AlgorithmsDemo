package leetcode;

import lintcode.TreeNode;

/**
 * @author Legend
 * @data by on 21-5-11.
 * @description https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class Test687 {

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return res - 1;
    }

    private int dfs(TreeNode root, int target) {
        if (root == null) return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        res = Math.max(res, 1 + left + right);
        if (root.val == target) {
            return  1 + Math.max(left, right);
        }
        return 0;
    }
}
