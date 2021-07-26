package leetcode;

/**
 * @author Legend
 * @data by on 21-5-29.
 * @description https://leetcode-cn.com/problems/maximum-score-from-performing-multiplication-operations/
 * idea:
 *      dp[i][j]表示取前i个元素和后j个元素的最大分数 对于当前步数,有两种取法
 *      1.取第i个元素, 总分为: dp[i-1][j] + cur*nums[i-1]
 *      2.取倒数第j个元素, 总分为: dp[i][j-1] + cur*nums[n-j]
 *      两者取最大值,
 *      初始值: dp[i][0]表示取前面i个元素,后面0个元素 只由取前面i-1个元素转移过来
 *             dp[0][i]表示取前面0个元素,后面i个元素 只由后面i-1个元素转移过来
 *
 *      结果: max(dp[i][m-i](0<=i<=m)) 即总共取m个元素的最大分数
 */
public class Test1770 {

    public int maximumScore(int[] nums, int[] muls) {
        int n = nums.length;
        int m = muls.length;
        int[][] dp = new int[m+1][m+1];
        for (int i = 1;i <= m;i++) dp[i][0] = dp[i-1][0] + muls[i-1]*nums[i-1];
        for (int i = 1;i <= m;i++) dp[0][i] = dp[0][i-1] + muls[i-1]*nums[n-i];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;i + j <= m;j++) {
                int cur = muls[i+j - 1];
                dp[i][j] = Math.max(dp[i-1][j] + cur*nums[i-1],
                        dp[i][j-1] + cur*nums[n-j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0;i <= m;i++) {
            max = Math.max(max, dp[i][m-i]);
        }
        return max;
    }
}
