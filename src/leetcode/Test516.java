package leetcode;

/**
 * @author Legend
 * @data by on 21-4-27.
 * @description https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class Test516 {

    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i++) {
            dp[i][i] = 1;
        }
        for (int len =2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = len + i - 1;
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
