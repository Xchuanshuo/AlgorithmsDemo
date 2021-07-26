package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-6-16.
 * @description https://leetcode-cn.com/problems/minimum-falling-path-sum-ii/
 */
public class Test1289 {

    public int minFallingPathSum(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int INF =(int)1e9;
        int[][] dp = new int[m+1][n+1];
        for (int[] d : dp) Arrays.fill(d, INF);
        int last = 0, lastPos = -1;
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (j == lastPos) continue;
                dp[i][j] = Math.min(dp[i][j], arr[i-1][j-1] +last);
            }
        }
        int min = INF;
        for (int i = 1;i <= n;i++) {
            min = Math.min(min, dp[m][i]);
        }
        return min;
    }

}
