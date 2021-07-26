package leetcode;

/**
 * @author Legend
 * @data by on 21-5-5.
 * @description https://leetcode-cn.com/problems/stone-game-vii/
 * idea:
 *      博弈型dp 同Test877 这里将得分换成了 移除掉左右两边的石子后,
 *      剩下的总和是多少 所以先计算前缀和即可
 */
public class Test1690 {

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + stones[i];
        int[][] dp = new int[n][n];
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(sum[j+1] - sum[i+1] - dp[i+1][j],
                                    sum[j] - sum[i] - dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
