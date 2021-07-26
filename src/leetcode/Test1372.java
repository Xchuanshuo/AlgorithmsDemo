package leetcode;

import lintcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-21.
 * @description https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree/
 * idea:
 *      解法1: 直接先序遍历 递归处理
 *      解法2: 树型dp, 用dp[0]表示从当前节点出发 向左走的最长交错路径
 *                      dp[1]表示从当前节点出发 向右走的最长交错路径
 *             状态转移方程: dp[0] = 1 + left[1] 当前节点到左子树 + 左子树向右走的路径长度
 *                         dp[1] = 1 + right[0] 当前节点到右子树 + 右子树向左走的路径长度
 */
public class Test1372 {

    int res = 0;
    Map<String, Integer> map = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        int left = helper(root.left, 1);
        int right = helper(root.right, 0);
        res = Math.max(res, Math.max(left, right));
    }

    private int helper(TreeNode root, int last) {
        if (root == null) return 0;
        String key = root  + "_" + last;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int t = 0;
        if (last == 0) {
            t = 1 + helper(root.left, 1);
        } else {
            t = 1 + helper(root.right, 0);
        }
        map.put(key, t);
        return t;
    }

    public int longestZigZag2(TreeNode root) {
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] dp = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (root.left != null) {
            dp[0] = left[1] + 1;
        }
        if (root.right != null) {
            dp[1] = right[0] + 1;
        }
        res = Math.max(res, dp[0]);
        res = Math.max(res, dp[1]);
        return dp;
    }
}
