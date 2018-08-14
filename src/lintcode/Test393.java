package lintcode;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description best-time-to-buy-and-sell-stock-iv
 * idea:
 *      动态规划 使用一个二维数组dp[k][i]表示 最多进行k次交易的情况下第i天可获得的最大收益
 *      第i天有两种选择 要么卖出股票 要么不卖出股票 那什么时候买入股票呢
 *      我们可以假设开始时买入股票 然后计算出每次交易的时候买入股票所需要的最小花费
 *      这样一来 即可计算出最大的收益 时间复杂度为O(KN)
 *
 *      还有一点需要注意的是，K可能比天数更加大， 这时候就没必要使用dp了 直接计算所有能获的
 *      收益的总和即为最大收益
 *
 */
public class Test393 {

    public int maxProfit(int K, int[] prices) {
        // write your code here
        int days = prices.length;
        if (K>=days/2) {
            int sum = 0;
            for (int i=1;i<days;i++) {
                if (prices[i]>prices[i-1]) {
                    sum += prices[i]-prices[i-1];
                }
            }
            return sum;
        }
        int[][] dp = new int[K+1][days+1];
        for (int k=1;k<=K;k++) {
            int max = dp[k-1][0] - prices[0];
            for (int i=1;i<days;i++) {
                // 第i天是否使用这个价格卖出
                dp[k][i] = Math.max(dp[k][i-1], max+prices[i]);
                // 第i天是否买入股票
                max = Math.max(max, dp[k-1][i]-prices[i]);
            }
        }
        return dp[K][days];
    }
}
