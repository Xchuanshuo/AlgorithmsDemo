package lintcode;

/**
 * @author Legend
 * @data by on 18-8-24.
 * @description dyeing-problem
 * idea:
 *      dp 排列问题 这里用dp[i]表示划分为i块时总共的方案数 划分成i块利用前面划分
 *      成的i-1块和i-2块的方案算来计算 因为存在有环的情况 所以前面3个要先算出来
 *      对于i-1位置 要保证和前后颜色均不相同 所以一共有dp[i-1]*(m-2)种方案
 *      对于i-2位置 只要保证和i-1位置颜色不相同即可 方案有dp[i-2]*(m-1)种方案
 *      因此i位置等于i-1位置和i-2位置的总共方案数之和
 */
public class Test1444 {

    public int getCount(int n, int m) {
        // Write your code here
        long p = 1000000007;
        long[] dp = new long[n+5];
        dp[1] = m%p;
        dp[2] = (long)m*(m-1)%p;
        dp[3] = (long)m*(m-1)*(m-2)%p;
        for (int i=4;i<=n;i++) {
            dp[i] = (dp[i-1]*(m-2) + dp[i-2]*(m-1))%p;
        }
        return (int) dp[n];
    }
}
