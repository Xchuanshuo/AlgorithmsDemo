package leetcode;

/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/maximal-square/
 * idea:
 *      以某个点为右下角的正方形, 只能从左边、上边、左上角的正方形扩展来.
 *      类似短板理论，取这三个位置为右下角正方形的最小边长的正方形
 */
public class Test221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (matrix[i-1][j-1] == '1') {
                    int min = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(min, dp[i][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
