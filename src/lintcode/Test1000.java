package lintcode;

/**
 * @author Legend
 * @data by on 18-9-6.
 * @description best-time-to-buy-and-sell-stock-with-transaction-fee
 * idea:
 *     dp 这里有两个状态 一个就是在前一天卖出股票后 买入当前股票是否能获得更多的利润
 *     即 buy=max(buy, sell-fee-prices[i]) ; 另一个状态是卖出持有股后是否能
 *     获得更多的利润 即sell=max(sell, buy+prices[i]) 这里还有一点需要注意
 *     初始状态下sell可获得的利润为0 而买入的状态是不存在的
 */
public class Test1000 {

    public int maxProfit(int[] prices, int fee) {
        // write your code here
        if (prices==null || prices.length==0) return 0;
        int buy = Integer.MIN_VALUE, sell = 0;
        for (int i=0;i<prices.length;i++) {
            // 买入当前股票能获得更多的利润
            buy = Math.max(buy, sell-(fee+prices[i]));
            // 卖出持有股是否能获得更多的利润
            sell = Math.max(sell, buy+prices[i]);
        }
        return sell;
    }
}
