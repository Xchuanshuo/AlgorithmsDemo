package leetcode;

/**
 * @author Legend
 * @data by on 21-4-25.
 * @description https://leetcode-cn.com/problems/uncrossed-lines/
 * idea:
 *      最长公共子串
 */
public class Test1035 {

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
