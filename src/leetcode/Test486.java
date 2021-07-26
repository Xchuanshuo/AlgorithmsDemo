package leetcode;

/**
 * @author Legend
 * @data by on 21-5-1.
 * @description https://leetcode-cn.com/problems/predict-the-winner/
 * idea:
 *      dp[i][j]表示对与区间[i,j] 先手比后手多出的最大得分为多少
 *      因为只能取两端点的值 假设取i, 那么先手比后手多的分数为 nums[i]-dp[i+1][j]
 *      其中dp[i][j+1]表示在区间[i,j+1] 之前的后手作为先手比对方多的最大得分
 *      同理 取j, 先手比后手多的得分为 nums[j]-dp[i][j-1] 两者取较大值
 *      所以最终状态转移方程 dp[i][j] = max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1])
 *      结果: dp[0][n-1] >= 0 也就是 看最终得分先手比后手多出的分数是否大于等于0
 */
public class Test486 {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1] >= 0;
    }
}
