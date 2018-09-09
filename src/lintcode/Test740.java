package lintcode;

/**
 * @author Legend
 * @data by on 18-9-9.
 * @description coin-change-2
 * idea:
 *      dp 背包问题 与Test562一样
 */
public class Test740 {

    public int change(int amount, int[] coins) {
        // write your code here
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i=0;i<coins.length;i++) {
            for (int j=coins[i];j<=amount;j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
