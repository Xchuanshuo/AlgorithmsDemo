package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-7-18.
 * @description https://leetcode-cn.com/problems/maximum-number-of-points-with-cost/
 * idea:
 *      dp[i][j] = points[i][j] + dp[i-1][k] - abs(j-k)
 *      将公式化简 从O(m*n*n)优化到O(m*n)
 *      1.当 j>=k, dp[i][j] = points[i][j] - j + dp[i-1][k]+k
 *      2.当 j<k, dp[i][j] = points[i][j] + j + dp[i-1][k]-k
 *      对于当前位置j,两种情况取较大值即可
 */
public class ITest5815 {

    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m+1][n+1];
        long INF = (int) 1e9;
        for (int i = 1;i <= m;i++) {
            long[] leftM = new long[n+1];
            Arrays.fill(leftM, -INF);
            long[] rightM = new long[n+2];
            Arrays.fill(rightM, -INF);
            for (int k = 1;k <= n;k++) {
                leftM[k] = Math.max(leftM[k-1], dp[i-1][k]+k);
            }
            for (int k = n;k >= 1;k--) {
                rightM[k] = Math.max(rightM[k+1], dp[i-1][k]-k);
            }
            for (int j = 1;j <= n;j++) {
                dp[i][j] = Math.max(dp[i][j],
                        Math.max(points[i-1][j-1] - j + leftM[j], points[i-1][j-1] + j + rightM[j+1]));
            }
        }
        long res = 0;
        for (int i = 0;i <= n;i++) {
            res = Math.max(res, dp[m][i]);
        }
        return res;
    }
}
