package lintcode;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description unique-paths
 * idea:
 *      dp问题 dp[i][j]表示位置i,j对应的路径数 从左上角开始遍历
 *      每个位置的数等于其左边的路径数+其上边的路径数
 *      即 dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class Test114 {

    public int uniquePaths(int m, int n) {
        // write your code here
        if (m==1 || n==1) return 1;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++) { dp[i][0] = 1; }
        for (int i=0;i<n;i++) { dp[0][i] = 1; }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
