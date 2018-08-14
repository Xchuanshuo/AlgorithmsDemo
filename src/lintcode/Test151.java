package lintcode;

/**
 * @author Legend
 * @data by on 18-8-13.
 * @description  best-time-to-buy-and-sell-stock-iii
 * idea:
 *      使用两个数组 分别表示从左边、从右边开始所获取到的最大收益
 *      最后结果就是 左边最大收益+右边最大收益
 */
public class Test151 {

    public int maxProfit(int[] prices) {
        // write your code here
        if (prices==null || prices.length==0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0], max = prices[prices.length-1];
        for (int i=1;i<prices.length;i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i]-min);
        }
        for (int i=prices.length-2;i>=0;i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max-prices[i]);
        }
        int result = 0;
        for (int i=0;i<prices.length;i++) {
            result = Math.max(result, left[i]+right[i]);
        }
        return result;
    }
}
