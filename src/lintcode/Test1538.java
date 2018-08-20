package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description card-game-ii
 * idea:
 *      dp 还是背包问题
 */
public class Test1538 {

    public boolean cardGame(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        // Write your code here
        int[] dp = new int[totalMoney+1];
        for (int i=0;i<cost.length;i++) {
            for (int j=totalMoney;j>=cost[i];j--) {
                dp[j] = Math.max(dp[j], dp[j-cost[i]]+damage[i]);
                if (dp[j]>=totalDamage) return true;
            }
        }
        return false;
    }
}
