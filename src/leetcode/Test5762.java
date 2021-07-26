package leetcode;

/**
 * @author Legend
 * @data by on 21-5-16.
 * @description https://leetcode-cn.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/
 * idea:
 *      逆向思维: 每次放木棍时先放比较大的最后放小的, 由较小的就可以决定 当前可见的数目
 *      dp[i][j]表示前i根木棍, 可以看到j根的方案数 要求dp[i][j] 可以分成两种情况
 *      1.前面i-1根木棍可以看到j-1根, 还剩一根最小的 放最前面即可 方案数为 dp[i-1][j-1]
 *      2.前面i-1根木棍可以看到j根, 那么剩余的一根最小的除了最前面外 可以放在任何地方
 *        此时的方案数为 (i-1)*dp[i-1][j]
 *      状态转移方程: dp[i][j] = dp[i-1][j-1] + (i-1)*dp[i-1][j]
 *      初始条件: dp[0][0] 表示0根木棍可以看到0根的方案数为1
 *      结果: dp[n][k], 即前n根木棍可以看到k根的方案总数
 */
public class Test5762 {

    public int rearrangeSticks(int n, int k) {
        int M = (int)1e9 + 7;
        long[][] dp = new long[n+1][k+1];
        dp[0][0] = 1;
        for (int i = 1;i <= n;i++) {
            int min = Math.min(i, k);
            for (int j = 1;j <= min;j++) {
                dp[i][j] = (dp[i-1][j-1] + (i-1)*dp[i-1][j])%M;
            }
        }
        return (int)(dp[n][k]%M);
    }
}
