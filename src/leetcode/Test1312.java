package leetcode;

/**
 * @author Legend
 * @data by on 21-4-17.
 * @description https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * idea:
 *      poj3280的简化
 */
public class Test1312 {

    public int minInsertions(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j],  dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][n-1];
    }
}
