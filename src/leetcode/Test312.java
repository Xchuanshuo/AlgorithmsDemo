package leetcode;

/**
 * @author Legend
 * @data by on 21-4-27.
 * @description https://leetcode-cn.com/problems/burst-balloons/
 * idea:
 *      区间dp 为方便处理边界 首先假设两边各加了1个数字为1的气球
 *      dp[i][j]表示区间i到j中间所有的气球戳破后的最大硬币数量
 *      接着 遍历所有区间 以及枚举所有气球戳破的位置k 则状态转移方程为
 *      dp[i][j] = dp[i][k] + dp[k][j] + arr[i]*arr[k]*arr[j]
 */
public class Test312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n+1] = 1;
        for (int i = 1;i <= n;i++) {
            arr[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for (int len = 3;len <= n+2;len++) {
            for (int i = 0;i <= n - len + 2;i++) {
                int j = i + len - 1;
                for (int k = i + 1;k < j;k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k]* arr[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
