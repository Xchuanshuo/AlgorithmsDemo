package lintcode;

/**
 * @author Legend
 * @data by on 18-9-7.
 * @description rogue-knight-sven
 * idea:
 *      dp dp[i][j]表示有i个星球 并且金币为j时　斯温可通过传送门到达目的地的方法数
 *     由于到达星球ｉ 只能由不超过limit距离的星球来传送 所以对于每个星球i 有0..i-limit(k)
 *     这些位置的星球都能 传送到星球i 而每种传送方式都需要cost[i]金币的花费 所以传送还有一个
 *     前提条件就是当前金币要足够 想清楚这些的话 就可以得出状态转移方程
 *     dp[i][j] += dp[k][j-cost[i]] 其中j-cost[i]>=0 还有注意初始化的情况
 *     就是当星球为0时需要传送的目的地就是本身 不需要传送 所以只有一种传送方式
 */
public class Test752 {

    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        long[][] dp = new long[n+1][m+1];
        for (int j=0;j<=m;j++) dp[0][j] = 1;
        for (int i=1;i<=n;i++) {
            for (int j=0;j<=m;j++) {
                for (int k=Math.max(0, i-limit);k<i;k++) {
                    dp[i][j] += j-cost[i]>=0?dp[k][j-cost[i]]:0;
                }
            }
        }
        return dp[n][m];
    }
}
