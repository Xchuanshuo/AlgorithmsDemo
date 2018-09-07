package lintcode;

/**
 * @author Legend
 * @data by on 18-9-7.
 * @description guess-number-higher-or-lower=ii
 * idea:
 *      dp 这道题一定要首先读懂题意 这里是求最少需要多少钱保证能赢 换个说法就是最坏情况下需要花费
 *      的钱最少 那什么是最坏情况？就是总也猜不对 明白这些就容易了 照样用而二分法 从左右开始查找
 *      不同的区间 对于区间里面的每一个数再继续进行枚举 用dp[l][r]表示区间l..r内求得的最小花费
 *      可以得出状态转移方程 dp[l][r]=min(dp[l][r], i+max(dp[l][i-1], dp[i+1][r]))
 */
public class Test666 {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int l=n-1;l>0;l--) {
            for (int r=l+1;r<=n;r++) {
                dp[l][r] = Integer.MAX_VALUE;
                for (int i=l;i<r;i++) {
                    dp[l][r] = Math.min(dp[l][r], i+Math.max(dp[l][i-1], dp[i+1][r]));
                }
            }
        }
        return dp[1][n];
    }
}
