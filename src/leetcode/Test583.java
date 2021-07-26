package leetcode;

/**
 * @author Legend
 * @data by on 21-4-25.
 * @description https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * idea:
 *      转换成求最长公共子串
 */
public class Test583 {

    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <=n;j++) {
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int most = dp[m][n];
        return m - most + n - most;
    }
}
