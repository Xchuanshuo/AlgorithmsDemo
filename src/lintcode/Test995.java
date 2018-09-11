package lintcode;

/**
 * @author Legend
 * @data by on 18-9-11.
 * @description best-time-to-buy-and-sell-stock-with-cooldown
 * idea:
 *      dp 用buy表示持有股票时可获得的最大利润 sell表示未持股时可获得的最大利润 这里每天
 *      都有3种状态 buy,sell,cooldown, 但可以把sell和cooldown看做同一种状态 都是未持股
 *      所以求sell有两种情况，一种是当前没有持股 那么就与前一天没有持股的情况一样；一种是当前持有
 *      股票 并且今天把当前股票卖出了. 同样的，求buy也有两种情况, 一种是当前已经持有股票 不卖出
 *      那么与前一天持有股票的情况一样；一种是前天卖出了股票，现在去买入股票. 所以可以得出状态转移方程
 *        sell=max(sell, buy+prices[i])         buy=max(buy, cooldown-prices[i])
 *      最后求出的sell即是可以获得的最大利润
 */
public class Test995 {

    public int maxProfit(int[] prices) {
        // write your code here
        int buy=Integer.MIN_VALUE, sell=0, cooldown=0;
        for (int i=0;i<prices.length;i++) {
            int temp = sell;
            sell = Math.max(sell, buy+prices[i]);
            buy = Math.max(buy, cooldown-prices[i]);
            cooldown = temp;
        }
        return sell;
    }
}
