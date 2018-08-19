package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-x
 * idea:
 *      背包问题 之前的背包问题1是求最多能装满多少空间 这里一样的求法
 *      dp[n]表示使用n最多能购买多少价值的商品 求出来dp[n]后
 *      再用n-dp[n]即剩下的买商品剩下的钱
 */
public class Test801 {

    public int backPackX(int n) {
        // write your code here
        int[] dp = new int[n+1];
        int[] prices = {150, 250, 350};
        for (int i=0;i<prices.length;i++) {
            for (int j=prices[i];j<=n;j++) {
                dp[j] = Math.max(dp[j], dp[j-prices[i]]+prices[i]);
            }
        }
        return n-dp[n];
    }
}
