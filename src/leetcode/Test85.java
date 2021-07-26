package leetcode;

/**
 * @author Legend
 * @data by on 21-4-27.
 * @description https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class Test85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (matrix[i-1][j-1] == '1' ) {
                    dp[i][j] = dp[i][j-1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (dp[i][j] < 1)  continue;
                int w, h = 1;
                for (w = dp[i][j];w >= 1;w--) {
                    int k = i;
                    while (k >= 1 && dp[k-1][j] >= w) {
                        h++;
                        k--;
                    }
                    max = Math.max(max, w * h);
                    h = 1;
                }
            }
        }
        return max;
    }
}
