package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-6-4.
 * @description https://leetcode-cn.com/problems/minimum-skips-to-arrive-at-meeting-on-time/
 * idea:
 *      dp[i][j]表示前i段路跳过j次休息最小花费总时间 对于当前路段i, 有两种选择
 *      1.跳过本次休息时间    dp[i][j] = dp[i-1][j-1] + h
 *      2.不跳过本次休息时间     dp[i][j] = ceil(dp[i-1][j] + h)
 *
 *      结果: 从 {dp[n][0],dp[n][1]...,dp[n][n]}中找到第一个小于会议时间的方案 即为最小跳过次数
 */
public class Test1883 {

    public int minSkips(int[] dist, int speed, int hours) {
        int n = dist.length;
        double eps = 1e-8;
        double[][] dp = new double[n+1][n+1];
        for (double[] d : dp) Arrays.fill(d, 1e9);
        dp[0][0] = 0;
        for (int i = 1;i <= n;i++) {
            double h = 1.0*dist[i-1]/speed;
            for (int j = 0;j <= i;j++) {
                dp[i][j] = Math.ceil(dp[i-1][j] + h - eps);
                if (j>=1)dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + h);
            }
        }
        for (int i = 0;i <= n;i++) {
            if (dp[n][i] <= hours) {
                return i;
            }
        }
        return -1;
    }
}
