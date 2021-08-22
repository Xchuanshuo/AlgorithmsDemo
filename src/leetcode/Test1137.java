package leetcode;

/**
 * @author Legend
 * @data by on 21-8-8.
 * @description https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class Test1137 {

    public int tribonacci(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i = 3;i <= n;i++) {;
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
