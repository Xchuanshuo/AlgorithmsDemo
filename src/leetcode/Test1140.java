package leetcode;

/**
 * @author Legend
 * @data by on 21-5-5.
 * @description https://leetcode-cn.com/problems/stone-game-ii/
 * idea:
 *      博弈型dp 要让当前得分最多, 就要对手得分尽可能的小
 *
 *      用dp[i][j]表示从i位置开始取 且M=j时先手能获取到的最大积分为多少
 *
 */
public class Test1140 {

    public int stoneGameII1(int[] piles) {
        int n = piles.length;
        int[] sum = new int[n+1];
        for (int i = n - 1;i >= 0;i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n+1];
        for (int i = n - 1;i >= 0;i--) {
            for (int m = 1;m <= n;m++) {
                if (i + 2*m >= n) {
                    dp[i][m] = sum[i];
                } else {
                    for (int x = 1;x <= 2*m;x++) {
                        dp[i][m] = Math.max(dp[i][m], sum[i] - dp[i+x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sum = new int[n+1];
        for (int i = n - 1;i >= 0;i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] mem = new int[n][2*n];
        return dfs(0, 1, sum, mem);
    }

    private int dfs(int i, int m, int[] sum, int[][] mem) {
        if (i >= sum.length - 1) return 0;
        if (i + 2 * m >= sum.length - 1) return sum[i];
        if (mem[i][m] != 0) return mem[i][m];
        int min = (int)1e9 + 7;
        for (int x = 1;x <= 2 * m;x++) {
            min = Math.min(min, dfs(i + x, Math.max(m, x), sum, mem));
        }
        int cur = sum[i] - min;
        mem[i][m] = cur;
        return cur;
    }
}
