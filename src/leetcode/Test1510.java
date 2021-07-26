package leetcode;

/**
 * @author Legend
 * @data by on 21-5-5.
 * @description https://leetcode-cn.com/problems/stone-game-iv/
 * idea:
 *      解法1. dfs + 记忆化搜索 当前的任意取法 只要有一个能让对方输 那当前就能赢
 *
 *      解法2. dp[i]表示当有i堆石头时 先手能否赢得比赛
 *            要让当前赢得比赛 需要取走某个数j的平方堆石头后 对方输掉比赛
 *            即 dp[i] = !dp[i-j*j]
 */
public class Test1510 {

    public boolean winnerSquareGame2(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 1;i <= n;i++) {
            int r = (int)Math.sqrt(i);
            for (int j = 1;j <= r;j++) {
                dp[i] = !dp[i - j*j];
                if (dp[i]) break;
            }
        }
        return dp[n];
    }

    public boolean winnerSquareGame1(int n) {
        Boolean[] mem = new Boolean[n+1];
        return dfs(n, mem);
    }

    private boolean dfs(int n, Boolean[] mem) {
        if (n == 0) return false;
        if (mem[n] != null) return mem[n];
        int r = (int) Math.sqrt(n);
        boolean canWin = false;
        for (int i = 1;i <= r;i++) {
            canWin = !dfs(n - i * i, mem);
            if (canWin) break;
        }
        return mem[n] = canWin;
    }
}
