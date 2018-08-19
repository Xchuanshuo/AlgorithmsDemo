package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description cutting-a-rod
 * idea:
 *      dp 还是背包问题 这是这里直接把i本身当作装入n需要的体积
 */
public class Test700 {

    public int cutting(int[] prices, int n) {
        // Write your code here
        int[] dp = new int[n+1];
        for (int i=1;i<=n;i++) {
            for (int j=i;j<=n;j++) {
                dp[j] = Math.max(dp[j], dp[j-i]+prices[i-1]);
            }
        }
        return dp[n];
    }
}
