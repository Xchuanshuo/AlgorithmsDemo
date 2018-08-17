package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description minimum-path-sum
 * idea:
 *      dp问题 与不同的路径问题一样 只是这里使用了滚动数组优化
 */
public class Test110 {

    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid==null || grid.length==0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        for (int i=0;i<n;i++) {
            dp[i+1] = dp[i] + grid[0][i];
        }
        dp[0] = Integer.MAX_VALUE;
        for (int i=1;i<m;i++) {
            for (int j=0;j<n;j++) {
                dp[j+1] = Math.min(dp[j+1], dp[j]) + grid[i][j];
            }
        }
        return dp[n];
    }
}
