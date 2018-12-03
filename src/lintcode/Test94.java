package lintcode;

/**
 * @author Legend
 * @data by on 18-12-3.
 * @description binary-tree-maximum-path-sum
 * idea:
 *      dfs 递归终止条件->当节点为空时
 *          返回值->以当前节点为终点的路径和最大
 */
public class Test94 {

    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, Math.max(0, left) + Math.max(0, right) + root.val);
        return Math.max(left, right) + root.val;
    }
}
