package lintcode;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description paint-house
 * idea:
 *      dp dp[i][j]表示第i个房子第j种颜色最小的花费
 *      所以dp[i][0]=min(dp[i-1][1], dp[i-1][2])+costs[i][0]
 *         dp[i][1]=min(dp[i-1][0], dp[i-1][2])+costs[i][1]
 *         dp[i][2]=min(dp[i-1][0], dp[i-1][1])+costs[i][2];
 *      初始状态dp[0][i]=costs[0][i]
 */
public class Test515 {

    public int minCost(int[][] costs) {
        // write your code here
        if (costs==null || costs.length==0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i=0;i<3;i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i=1;i<n;i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
