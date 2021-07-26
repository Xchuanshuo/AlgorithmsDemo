package leetcode;

/**
 * @author Legend
 * @data by on 21-4-18.
 * @description https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * idea:
 *      dp[i]表示位数为i的不同的数字个数 要求0-10^n的每位都不同的数字个数
 *      只需要累加从(0..n)位的个数即可
 */
public class Test357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 9;
        int sum = dp[0] + dp[1];
        for (int i = 2;i <= n;i++) {
            dp[i] = dp[i-1] * (10 - (i -1));
            sum += dp[i];
        }
        return sum;
    }
}
