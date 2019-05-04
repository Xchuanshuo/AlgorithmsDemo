package lintcode;

/**
 * @author Legend
 * @data by on 19-5-4.
 * @description predict-the-winner
 * idea:
 *      与Test396一样...
 */
public class Test670 {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1;i <= n;i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i++) {
            dp[i][i] = nums[i];
        }
        for (int j = 2;j <= n;j++) {
            for (int i = 0;i < j;i++) {
                int s = sum[j+1] - sum[i];
                dp[i][j] = s - Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1] > sum[n]/2;
    }
}
