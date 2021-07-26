package leetcode;

import lintcode.TreeNode;

/**
 * @author Legend
 * @data by on 21-5-21.
 * @description https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/
 */
public class Test1339 {

    int M = (int)1e9 + 7;
    long res = 0;
    public int maxProduct(TreeNode root) {
        long total =  sum(root);
        helper(root, total);
        return (int)(res%M);
    }

    private long helper(TreeNode root, long total) {
        if (root == null) return 0;
        long split = root.val + helper(root.left, total) + helper(root.right, total);
        res = Math.max(res, (total-split) * split);
        return split;
    }

    private long sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
