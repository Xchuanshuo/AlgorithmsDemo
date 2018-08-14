package lintcode;

/**
 * @author Legend
 * @data by on 18-8-13.
 * @description best-time-to-buy-and-sell-stock
 * idea:
 *      贪心算法
 */
public class Test149 {

    public int maxProfit(int[] prices) {
        // write your code here
        if (prices==null || prices.length==0) return 0;
        int max = 0, min = prices[0];
        for (int i=1;i<prices.length;i++) {
            max = Math.max(max, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
