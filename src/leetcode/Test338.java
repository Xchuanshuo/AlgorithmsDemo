package leetcode;

/**
 * @author Legend
 * @data by on 21-4-18.
 * @description https://leetcode-cn.com/problems/counting-bits/
 */
public class Test338 {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if (num == 0)  return dp;
        dp[0] = 0;dp[1] = 1;
        for (int i = 2;i <= num;i++) {
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
}
