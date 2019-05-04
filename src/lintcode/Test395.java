package lintcode;

/**
 * @author Legend
 * @data by on 19-5-3.
 * @description coins-in-a-line-ii
 * idea:
 *     dp dp[i]表示还剩余i个硬币时最多可以获得多少钱 要求dp[i]需要知道dp[i-1]和dp[i-2]的情况
 *     要使当前取得最多的钱，就得使前一个人尽量取得最小价值的钱 而总钱数是固定的 所以只要知道前一个
 *     人取钱的最小价值 直接用当前剩余的总钱数-最小 就可使当前取得最大的价值 可以得到状态转移方程
 *     dp[i] = sum[i] - min(dp[i-1], dp[i-2]) 最后dp[n]就表示剩余n个硬币时 能取得的总钱数
 *     只要该值大于总钱数的一半 即可得出该选手必赢
 */
public class Test395 {

    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int[] sum = new int[n+1];
        for (int i=1;i<=n;i++) {
            sum[i] = sum[i-1] + values[n-i];
        }
        int[] dp = new int[n+1];
        dp[1] = values[n-1];
        for (int i=2;i<=n;i++) {
            dp[i] = sum[i] - Math.min(dp[i-1], dp[i-2]);
        }
        return dp[n]>sum[n]/2;
    }
}
