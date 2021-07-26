package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-6-24.
 * @description https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class Test1334 {

    public int findTheCity(int n, int[][] edges, int t) {
        int INF = (int)1e9;
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, INF);
        for (int[] e : edges) {
            dp[e[0]][e[1]] = e[2];
            dp[e[1]][e[0]] = e[2];
        }
        for (int k = 0;k < n;k++) {
            for (int i = 0;i < n;i++) {
                for (int j = 0;j < n;j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] +  dp[k][j]);
                }
            }
        }
        int res = 0, cur = n + 1;
        for (int i = n-1;i >= 0;i--) {
            int cnt = 0;
            for (int j = 0;j < n;j++) {
                if (i != j && dp[i][j] <= t) {
                    cnt++;
                }
            }
            if (cnt < cur) {
                cur = cnt;
                res = i;
            }
        }
        return res;
    }
}
