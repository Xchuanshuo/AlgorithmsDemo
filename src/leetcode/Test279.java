package leetcode;

/**
 * @author Legend
 * @data by on 21-6-11.
 * @description https://leetcode-cn.com/problems/perfect-squares/
 */
public class Test279 {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1;i <= n;i++) {
            dp[i] = (int)1e9;
            for (int j = 1;j*j <= i;j++) {
                dp[i] =  Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }
}
