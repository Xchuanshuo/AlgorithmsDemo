package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description coin-change
 * idea:
 *      dp 本来想用贪心来解决的，结果提交了才发现coins的数据都是乱给的 所以还是要用
 *      动态规划 这题和背包问题很相似 dp[j]表示总金额为j时所需的硬币最小数量
 *      如果存在金币能组合成总金额j-coins[i]的情况 那么对于总金额j 就要取前面使用金币
 *      数量较小的情况 即得出状态转移方程 dp[j] = min(dp[j], dp[j-coins[i]]+1)
 *      还有需要注意初始值 总金额为0时需要金币数量为0个 即dp[0]=0
 */
public class Test669 {

    public int coinChange(int[] coins, int amount) {
        // write your code here
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=0;i<coins.length;i++) {
            for (int j=coins[i];j<=amount;j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
