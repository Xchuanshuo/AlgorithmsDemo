package lintcode;

/**
 * @author Legend
 * @data by on 18-9-9.
 * @description counting-bits
 * idea:
 *      dp 有点trick的一道题 5=101 有两个1, 右移一位变成2，2=10 有一个1 右移一位变成1,
 *      0=0 有0个1, 所以dp[5]=dp[2]+1, dp[2]=dp[1], dp[1]=dp[0]+1 规律自然就出来了
 *      当i是奇数时 dp[i]=dp[i>>1]+1, 当i是偶数时 dp[i]=dp[i>>1] 所以可以得出状态转移方程
 *       dp[i] = dp[i>>1] + (i&1)
 */
public class Test664 {

    public int[] countBits(int num) {
        // write your code here
        int[] dp = new int[num+1];
        for (int i=1;i<=num;i++) {
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
}
