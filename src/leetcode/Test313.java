package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-6-25.
 * @description https://leetcode-cn.com/problems/super-ugly-number/
 */
public class Test313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        int[] p = new int[1001];
        Arrays.fill(p, 1);
        dp[1] = 1;
        for (int i = 2;i <= n;i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0;j < primes.length;j++) {
                int cur = dp[p[primes[j]]] * primes[j];
                if (cur < min) {
                    min = cur;
                }
            }
            dp[i] = min;
            for (int j = 0;j < primes.length;j++) {
                int cur = dp[p[primes[j]]] * primes[j];
                if (cur == min) p[primes[j]]++;
            }
        }
        return dp[n];
    }
}
