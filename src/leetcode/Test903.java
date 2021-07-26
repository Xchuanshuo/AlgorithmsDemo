package leetcode;

/**
 * @author Legend
 * @data by on 21-6-23.
 * @description https://leetcode-cn.com/problems/valid-permutations-for-di-sequence/
 * idea:
 *      求排列个数的套路, dp数组用一维表示某个数结尾时的方案.
 *      这里用dp[i][j]表示前i个数, 以数j结尾时满足"DI"的排列方案数
 *      对于前i个数, 枚举当前所有可选数j(0<=j<=i), 分为两种情况
 *      1.若当前的DI序列字符为'D' 则前一个数需要大于等于当前数j,(当前数j放末尾,将>=j的数+1)
 *      即 dp[i][j] += dp[i-1][k] (j<=k<=i)
 *      2.若当序列字符为'I',则前一个数需要小于当前数j,
 *      即 dp[i][j] += dp[i-1][k] (0<=k<j)
 *
 *      最后累计前N个数, 以所有数结尾的方案, 即 sum(dp[n][0],dp[n][1]...,dp[n][n])
 */
public class Test903 {

    public int numPermsDISequence(String s) {
        int n =  s.length(), M = (int)1e9 + 7;
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 1;
        for (int i = 1;i <= n;i++) {
            for (int j = 0;j <= i;j++) {
                if (s.charAt(i-1) == 'D') {
                    for (int k = j;k < i;k++) {
                        dp[i][j] = (dp[i][j] + dp[i-1][k])%M;
                    }
                } else {
                    for (int k = 0;k < j;k++) {
                        dp[i][j] = (dp[i][j] + dp[i-1][k])%M;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0;i <= n;i++) {
            res = (res + dp[n][i])%M;
        }
        return res;
    }
}
