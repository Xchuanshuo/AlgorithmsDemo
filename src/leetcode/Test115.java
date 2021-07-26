package leetcode;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/distinct-subsequences/
 */
public class Test115 {

    public int numDistinct(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int m = sc.length, n = tc.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0;i <= m;i++) {
            dp[i][0] = 1;
        }
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (sc[i-1] == tc[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
