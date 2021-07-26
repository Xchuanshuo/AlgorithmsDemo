package leetcode;

/**
 * @author Legend
 * @data by on 21-7-18.
 * @description https://leetcode-cn.com/problems/rotated-digits/
 */
public class Test788 {

    public int rotatedDigits(int n) {
        boolean[] dp = new boolean[n+10];
        dp[1] = dp[2] = dp[8] = true;
        dp[5] = dp[6] = dp[9] = true;
        int res = 0;
        for (int i = 2;i <= n;i++) {
            int last = i%10;
            if (last == 3 || last == 4 || last == 7) continue;
            if (dp[i/10]) dp[i] = true;
            if (dp[i] && isValid(i)) res++;
        }
        return res;
    }

    private boolean isValid(int val) {
        while (val != 0) {
            int cur = val%10;
            if (cur == 2 || cur == 5 || cur == 6 || cur == 9) return true;
            val /= 10;
        }
        return false;
    }
}
