package leetcode;

/**
 * @author Legend
 * @data by on 21-6-25.
 * @description https://leetcode-cn.com/problems/01-matrix/
 * idea:
 *      注意边界!
 */
public class Test542 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (mat[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = (int)1e9;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j-1] + 1;
                    } else if (j == 0) {
                        dp[i][j] = dp[i-1][j] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    }
                }
            }
        }
        for (int i = m - 1;i >= 0;i--) {
            for (int j = n - 1;j >= 0;j--) {
                if (mat[i][j] == 1) {
                    if (i == m - 1 && j == n-1) continue;
                    if (i == m - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                    } else if (j == n - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                    } else {
                        dp[i][j] = Math.min(dp[i][j],  Math.min(dp[i+1][j], dp[i][j+1]) + 1);
                    }
                }
            }
        }
        return dp;
    }
}
