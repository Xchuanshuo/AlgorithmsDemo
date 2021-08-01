package leetcode.lcp252;

/**
 * @author Legend
 * @data by on 21-8-1.
 * @description count-number-of-special-subsequences
 * idea:
 *      dp[i][j] 位置i以j结尾的序列方案数
 *      三种情况 1.当前为0, 可以直接将0接在前面所有为0的序列结尾;可以直接用当前0替换掉
 *               前面所有序列的最后一个位置;可以直接假设序列从当前位置的0开始 所以得到转移方程
 *               dp[i][0] = dp[i-1][0]*2 + 1
 *             2.当前为1, 可以直接将1接在前面所有为0的序列结尾;可以直接将当前1接在前面所有结尾为1的
 *               序列的最后;可以直接将1替换前面所有序列结尾为1的位置;
 *               dp[i][1] = dp[i-1][0] + dp[i-1][1]*2;
 *             3.当前为2, 同理
 *               dp[i][2] = dp[i-1][1] + dp[i-1][2]*2;
 */
public class Test5833 {

    public int countSpecialSubsequences(int[] nums) {
        int n = nums.length, M = (int)1e9 + 7;
        long[][] dp = new long[n+1][3];
        for (int i = 1;i <= n;i++) {
            if (nums[i-1] == 0) {
                dp[i][0] = (2*dp[i-1][0] + 1)%M;
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-1][2];
            } else if (nums[i-1] == 1) {
                dp[i][1] = (dp[i-1][0] + 2*dp[i-1][1])%M;
                dp[i][0] = dp[i-1][0];
                dp[i][2] = dp[i-1][2];
            } else {
                dp[i][2] = (dp[i-1][1] + 2*dp[i-1][2])%M;
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
            }
        }
        return (int)dp[n][2];
    }
}
