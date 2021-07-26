package leetcode;

/**
 * @author Legend
 * @data by on 21-5-28.
 * @description https://leetcode-cn.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
 * idea:
 *      dp[n][k]表示前n个点分成k条不重叠线段的方案数
 *      对于(1)dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-2][j-1] + ... + dp[1][j-1]
 *         (2)dp[i-1][j] = dp[i-2][j] + dp[i-2][j-1] + ... + dp[1][j-1]
 *
 *         (1)-(2) --> dp[i][j]-dp[i-1][j]= dp[i-1][j] + dp[i-1][j-1] - dp[i-2][j]
 *                     即 dp[i][j] = 2*dp[i-1][j] + dp[i-1][j-1] - dp[i-2][j]
 */
public class Test1621 {

    public int numberOfSets(int n, int K) {
        int M = (int)1e9 + 7;
        long[][] dp = new long[n+1][K+1];
        for(int i = 0;i <= n;i++) dp[i][0] = 1;
        for (int i = 2;i <= n;i++) {
            int r = Math.min(K, i);
            for (int j = 1;j <= r;j++) {
                dp[i][j] = 2*dp[i-1][j] + dp[i-1][j-1] - dp[i-2][j];
                dp[i][j] += M;
                dp[i][j] %= M;
            }
        }
        return (int)(dp[n][K]%M);
    }
}
