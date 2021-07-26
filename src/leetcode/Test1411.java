package leetcode;

import java.util.Collections;

/**
 * @author Legend
 * @data by on 21-4-19.
 * @description https://leetcode-cn.com/problems/number-of-ways-to-paint-n-3-grid/
 */
public class Test1411 {

    public int numOfWays(int n) {
        if (n == 1) return 12;
        int M = 1000000007;
        long[][] dp = new long[n+1][2];
        dp[1][0] = 6; // abc
        dp[1][1] = 6; // aba
        for (int i = 2;i  <= n;i++) {
            dp[i][0] = (2*dp[i-1][0] + 2*dp[i-1][1])%M;
            dp[i][1] = (2*dp[i-1][0] + 3*dp[i-1][1])%M;
        }
        return (int)(dp[n][0] + dp[n][1])%M;
    }
}
