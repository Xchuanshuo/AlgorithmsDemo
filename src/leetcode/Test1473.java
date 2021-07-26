package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-4.
 * @description https://leetcode-cn.com/problems/paint-house-iii/
 * idea:
 *      dp[i][j][k]表示前i个房子使用j种颜色染成k个街区所需的最小总花费
 *      枚举所有相邻房子使用染成不同颜色的情况, 分为两种情况
 *      1.当前房子已经染过色, 无需新的花费 总花费直接从前一个染色后的房子转移过来,
 *        对于前一个房子与当前房子也有两种情况,颜色相同或者不相同
 *        相同: dp[i][j][k] = dp[i-1][j][k]    总的街区数不变
 *        不同: dp[i][j][k] = dp[i-1][j][k-1]  总的街区数+1
 *
 *      2.当前没染过色, 当前染成j+1种颜色的花费为cost[i][j] 同样分为两种情况,
 *        相同: dp[i][j][k] = dp[i-1][j][k] + cost[i][j]
 *        不同: dp[i][j][k] = dp[i-1][j][k-1] + cost[i][j]
 *
 *      结果: min(dp[i][0..n-1][target])
 */
public class Test1473 {

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        final int INF = (int)1e9;
        int[][][] dp = new int[m][n][target + 1];
        for (int[][] d1 : dp) {
            for (int[] d : d1) Arrays.fill(d, INF);
        }
        for (int i = 0;i < m;i++) {
            for (int k = 1;k <= target;k++) {
                for (int pre = 0;pre < n;pre++) {
                    for (int cur = 0;cur < n;cur++) {
                        if (houses[i] != 0 && houses[i] != cur + 1) continue;
                        int consume = houses[i] != 0 ? 0 : cost[i][cur];
                        if (i == 0) {
                            if (k == 1) dp[i][cur][k] = consume;
                        } else {
                            if (pre == cur) {
                                dp[i][cur][k] = Math.min(dp[i][cur][k], dp[i-1][pre][k] + consume);
                            } else {
                                dp[i][cur][k] = Math.min(dp[i][cur][k], dp[i-1][pre][k-1] + consume);
                            }
                        }
                    }
                }
            }
        }
        int res = INF;
        for (int i = 0;i < n;i++) {
            res = Math.min(res, dp[m-1][i][target]);
        }
        return res == INF ? -1 : res;
    }
}
