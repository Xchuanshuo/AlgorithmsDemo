package leetcode;

/**
 * @author Legend
 * @data by on 21-5-15.
 * @description https://leetcode-cn.com/problems/largest-sum-of-averages/
 * idea:
 *      dp[i][k]表示前i个数分成j份所获得的最大分组平均值和
 *      直接枚举i前面的位置j, 从j到i分为1组, 前j个数分为k-1组
 *      即状态转移方程为 dp[i][k]=max(dp[i][k], dp[j][k-1] + avg)
 *      优化: 对于分割成k组, 只依赖于分割成k-1组的状态 所以可以优化成1维
 *           类似背包问题 需要从后往前计算
 */
public class Test813 {

    public double largestSumOfAverages(int[] nums, int K) {
        int n = nums.length;
        double[] sum = new double[n+1];
        for (int i = 0;i < nums.length;i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        double[][] dp = new double[n+1][K+1];
        for (int i = 1;i <= n;i++) {
            dp[i][1] = sum[i]/i;
        }
        for (int k = 2;k <= K;k++) {
            for (int i = 1;i <= n;i++) {
                for (int j = 1;j < i;j++) {
                    double avg =  (sum[i]-sum[j])/(i-j);
                    dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + avg);
                }
            }
        }
        return dp[n][K];
    }

    public double largestSumOfAverages2(int[] nums, int K) {
        int n = nums.length;
        double[] sum = new double[n+1];
        for (int i = 0;i < nums.length;i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        double[] dp = new double[n+1];
        for (int i = 1;i <= n;i++) {
            dp[i] = sum[i]/i;
        }
        for (int k = 2;k <= K;k++) {
            for (int i = n;i >= 2;i--) {
                for (int j = 1;j < i;j++) {
                    double avg =  (sum[i]-sum[j])/(i-j);
                    dp[i] = Math.max(dp[i], dp[j] + avg);
                }
            }
        }
        return dp[n];
    }
}
