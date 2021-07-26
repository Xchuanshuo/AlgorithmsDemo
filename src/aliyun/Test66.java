package aliyun;

/**
 * @author Legend
 * @data by on 21-4-6.
 * @description https://developer.aliyun.com/coding/66
 * idea:
 *      1.找到最小价格, value/最小价格 表示能取到数的最大位数m
 *      2.得到数的最大位数后, 再去模拟比较获取最大的值 也就是买了多个最小价格后，
 *      还剩余多少, 用【剩余的钱+最小价格】看能否选取到更大的数
 *      如: 余额:8 最小:3 存在一个为5 最大个数为8/3=2 剩余8%3=2
 *      2+3=5，刚好存在为5的价格，那么优先选取5
 */
public class Test66 {

    public static String solution(int value, int[] prices) {
        int minPrice = Integer.MAX_VALUE, idx = 0;
        for (int i = 0;i < prices.length;i++) {
            if (minPrice >= prices[i]) {
                minPrice = prices[i];
                idx = i + 1;
            }
        }
        int m = value / minPrice;
        int remain = value % minPrice;
        if (m == 0) return "-1";
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int cur = idx;
            if (remain > 0) {
                for (int i = 0;i < prices.length;i++) {
                    if (prices[i] <= minPrice + remain) {
                        cur = Math.max(cur, i + 1);
                    }
                }
            }
            sb.append(cur);
            remain = remain + minPrice - prices[cur - 1];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int value = 1000000;
        int[] prices = {2,2,2,2,2,2,2,2,2};
        String str = solution(value, prices);
        System.out.println(str);
    }
}
