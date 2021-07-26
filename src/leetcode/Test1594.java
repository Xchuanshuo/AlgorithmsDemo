package leetcode;

/**
 * @author Legend
 * @data by on 21-5-28.
 * @description https://leetcode-cn.com/problems/maximum-non-negative-product-in-a-matrix/
 * idea:
 *      因为存在负数, 最大值*负数后变为最小值, 负数*最小负数后变为最大值
 *      所以需要记录每个位置的最小值与最大值 用dp[i][j][0]表示到达位置
 *      (i,j)的最小值, dp[i][j][1]表示到达位置(i,j)的最大值 分为两种情况
 *      1. cur>=0, dp[i][j][0] = Math.min(dp[i-1][j][0], dp[i][j-1][0]) * cur;
 *                 dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i][j-1][1]) * cur;
 *      2. cur<0,  dp[i][j][0] = Math.max(dp[i-1][j][1], dp[i][j-1][1]) * cur;
 *                 dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i][j-1][0]) * cur;
 *
 *      初始条件: 第1行与第1列最大值与最小值相同
 *      结果: dp[m-1][n-1][1] 即到达矩阵右下角的最大值
 */
public class Test1594 {

    public int maxProductPath(int[][] grid) {
        int m = grid.length,  n = grid[0].length;
        int M = (int)1e9 + 7;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for (int i = 1;i < m;i++) {
            dp[i][0][0] = dp[i][0][1] = grid[i][0]*dp[i-1][0][0];
        }
        for (int i = 1;i < n;i++) {
            dp[0][i][0] = dp[0][i][1] = grid[0][i]*dp[0][i-1][0];
        }
        for (int i = 1;i < m;i++) {
            for (int j = 1;j < n;j++) {
                int cur = grid[i][j];
                if (cur >= 0) {
                    dp[i][j][0] = Math.min(dp[i-1][j][0], dp[i][j-1][0]) * cur;
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i][j-1][1]) * cur;
                } else {
                    dp[i][j][0] = Math.max(dp[i-1][j][1], dp[i][j-1][1]) * cur;
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i][j-1][0]) * cur;
                }
            }
        }
        return (int)(dp[m-1][n-1][1] < 0 ? -1 : dp[m-1][n-1][1]%M);
    }
}
