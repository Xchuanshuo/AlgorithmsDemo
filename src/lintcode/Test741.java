package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-9-6.
 * @description calculate-maximum-value-ii
 * idea:
 *      记忆化搜索+分治 这题与Test719不同的是可以在任何地方加入括号 而加括号可以在
 *      任意位置 所以这是典型的区间型dp 用dp[i][j]表示在区间(i,j)内取得的最大值
 *      先计算出小区间内的最大值 再不断的扩大 最后即可得出大区间内的最大值 因为计算大
 *      区间时需要依赖小区间的计算结果 所以采用记忆化搜索的方式来保存计算后的结果
 */
public class Test741 {

    public int maxValue(String str) {
        // write your code here
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int[] arr: dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return helper(str, 0, n-1, dp);
    }

    private int helper(String str, int l, int r, int[][] dp) {
        if (dp[l][r] != Integer.MIN_VALUE) return dp[l][r];
        if (l == r) {
            dp[l][r] = str.charAt(l)-'0';
            return dp[l][r];
        }
        for (int i=l;i<r;i++) {
            int left = helper(str, l, i, dp);
            int right = helper(str, i+1, r, dp);
            dp[l][r] = Math.max(dp[l][r], Math.max(left*right, left+right));
        }
        return dp[l][r];
    }
}
