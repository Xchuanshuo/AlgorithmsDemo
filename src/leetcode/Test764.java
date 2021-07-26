package leetcode;

/**
 * @author Legend
 * @data by on 21-5-12.
 * @description https://leetcode-cn.com/problems/largest-plus-sign/
 */
public class Test764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        boolean[][] t = new boolean[N][N];
        for (int[] mine : mines) {
            t[mine[0]][mine[1]] = true;
        }
        int[][][] dp = new int[N+1][N+1][2];
        for (int i = 1;i <= N;i++) {
            for (int j = 1;j <= N;j++) {
                if (!t[i-1][j-1]) {
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 1;i <= N;i++) {
            for (int j = 1;j <= N;j++) {
                int min = Math.min(dp[i][j][0], dp[i][j][1]);
                if (min == 0 || min <= res) continue;
                for (int e = min;e >= 1;e--) {
                    int rIdx = j + e - 1;
                    int bIdx = i + e - 1;
                    if (rIdx > N || bIdx > N) continue;
                    if (dp[i][rIdx][0] >= 2*e-1 && dp[bIdx][j][1] >= 2*e-1) {
                        res = Math.max(res, e);
                    }
                }
            }
        }
        return res;
    }
}
