package lintcode;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description unique-paths-ii
 * idea:
 *      unique-paths(Test114)的升级版 只需要加一个过滤条件
 *      从i..j的路径如果有值为0 说明这条路就走不通 直接将dp[i][j]置为0即可
 */
public class Test115 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid==null || obstacleGrid.length==0) return -1;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++) {
            if(obstacleGrid[i][0]==1) break;
            dp[i][0] = 1;
        }
        for (int i=0;i<n;i++) {
            if(obstacleGrid[0][i]==1) break;
            dp[0][i] = 1;
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (obstacleGrid[i][j]==1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
