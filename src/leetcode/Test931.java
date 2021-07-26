package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-27.
 * @description https://leetcode-cn.com/problems/minimum-falling-path-sum/
 */
public class Test931 {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+2];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 0;i <= n;i++) dp[0][i] = 0;
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                int min = Math.min(dp[i-1][j+1], dp[i-1][j-1]) ;
                dp[i][j] = Math.min(min, dp[i-1][j]) + matrix[i-1][j-1];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1;i <= n;i++) {
            min = Math.min(min, dp[m][i]);
        }
        return min;
    }
}
