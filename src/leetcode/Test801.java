package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing/
 * idea:
 *      dp[i][0]表示位置i交换, dp[i][1]表示位置i交换
 *      初始条件: dp[0][0] = 0, dp[0][1] = 1
 *      状态: 若A[i]>A[i-1] && B[i]>B[i-1],则dp[i][0]=dp[i-1][0], dp[i][1]=dp[i-1][1] + 1
 *          若A[i]>B[i-1] && B[i]>A[i-1], 则dp[i][0]=dp[i-1][1], dp[i][1]=dp[i-1][0] + 1
 */
public class Test801 {

    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        if (n <= 1) return 0;
        int[][] dp = new int[n][2];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1;i < n;i++) {
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + 1);
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + 1);
            }
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
}
