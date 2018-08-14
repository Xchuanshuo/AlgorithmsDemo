package lintcode;

/**
 * @author Legend
 * @data by on 18-8-13.
 * @description best-time-to-buy-and-sell-stock-ii
 * idea:
 *      贪心算法 就是计算所有收益的情况
 */
public class Test150 {

    public int maxProfit(int[] prices) {
        // write your code here
        if (prices==null || prices.length==0) return 0;
        int sum = 0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i]>prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}
