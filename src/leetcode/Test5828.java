package leetcode;

import tree.heap.Array;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-8-8.
 * @description https://leetcode-cn.com/problems/minimum-total-space-wasted-with-k-resizing-operations/
 * idea:
 *      dp[i][j] 表示前i个数分成j段，求j段最小值之和
 *      1.预处理求前缀和 和 任意区间最大值
 *      2.dp[i][j] = dp[l][j-1] + (i-l+1)*max[l-1][i-1] - (sum[i] - sum[l-1])
 *       即枚举以当前位置i结尾的任意长度的区间 为选取的第j段 第j段浪费空间为该
 *       区间最大空间*区间长度 - 实际需要的空间
 */
public class Test5828 {

    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length, INF = (int)1e9; k += 1;
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + nums[i];
        int[][] max = new int[n][n];
        for (int len = 1;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (len == 1) max[i][j] = nums[i];
                else max[i][j] = Math.max(max[i][j-1], nums[j]);
            }
        }
        int[][] dp = new int[n+1][k+1];
        for (int[] d : dp) Arrays.fill(d, INF);
        dp[0][0] = 0;
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= i && j <= k;j++) {
                for (int l = i;l >= 1;l--) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[l-1][j-1] + (i-l+1)*max[l-1][i-1] - (sum[i] - sum[l-1]));
                }
            }
        }
        return dp[n][k];
    }
}
