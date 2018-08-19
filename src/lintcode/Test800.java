package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-ix
 * idea:
 *      背包问题 dp[n]表示拥有n万元时 可获得至少一所大学offer的最大概率
 *      这里求至少获得一所大学offer最大的概率 可以转换为求所有大学都没获得offer的
 *      最小概率 这样一来就转化为普通的背包问题
 */
public class Test800 {

    public double backpackIX(int n, int[] prices, double[] probability) {
        // write your code here
        double[] dp = new double[n+1];
        for (int i=0;i<prices.length;i++) {
            for (int j=n;j>=prices[i];j--) {
                dp[j] = Math.max(dp[j], 1-(1-dp[j-prices[i]])*(1-probability[i]));
            }
        }
        return dp[n];
    }

}
