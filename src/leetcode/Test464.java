package leetcode;

/**
 * @author Legend
 * @data by on 21-5-6.
 * @description https://leetcode-cn.com/problems/can-i-win/
 * idea:
 *      状压dp
 */
public class Test464 {

    public boolean canIWin(int max, int total) {
        if (max >= total) return true;
        if (max * (1 + max)/2 < total) return false;
        Boolean[] dp = new Boolean[1 << 21];
        return dfs(max, total,  dp, 0);
    }

    private boolean dfs(int max, int total, Boolean[] dp, int state) {
        if (dp[state] != null) return dp[state];
        if (total <= 0) {
            dp[state] = false;
            return false;
        }
        for (int i = 1;i <= max;i++) {
            int cur = 1 << i - 1;
            if ((state & cur) != 0) continue;
            boolean win = dfs(max,  total - i, dp, state | cur);
            if (!win) {
                dp[state] = true;
                return true;
            }
        }
        dp[state] = false;
        return false;
    }
}
