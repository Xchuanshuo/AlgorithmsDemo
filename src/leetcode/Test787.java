package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-13.
 * @description https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/
 * idea:
 *      最短路 1.floyd多源最短路
 *            2.BellmanFord最短路
 *            3.Dijkstra最短路
 */
public class Test787 {

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        int INF = (int)1e9;
        int[][][] dp = new int[n][n][K+1];
        for (int[][] d2 : dp) {
            for (int[] d1 : d2) Arrays.fill(d1, INF);
        }
        for (int[] flight : flights) {
            dp[flight[0]][flight[1]][0] = flight[2];
        }
        for (int k = 1;k <= K;k++) {
            for (int i = 0;i < n;i++) {
                for (int j = 0;j < n;j++) {
                    for (int x = 0;x < n;x++) {
                        if (dp[i][j][k] >= dp[i][x][k-1] + dp[x][j][1]) {
                            dp[i][j][k] = dp[i][x][k-1] + dp[x][j][1];
                        }
                    }
                }
            }
        }
        return dp[src][dst][K] == INF ? -1 : dp[src][dst][K];
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        int INF = (int)1e9;
        int[][] dp = new int[n][K+2];
        for (int[] d1 : dp) Arrays.fill(d1, INF);
        for (int i = 0;i <= K+1;i++) dp[src][i] = 0;
        for (int k = 1;k <= K+1;k++) {
            for (int[] flight : flights) {
                if (dp[flight[0]][k-1] != INF &&
                        dp[flight[1]][k] > dp[flight[0]][k-1] + flight[2]) {
                    dp[flight[1]][k] = dp[flight[0]][k-1] + flight[2];
                }
            }
        }
        return dp[dst][K+1] == INF ? -1 : dp[dst][K+1];
    }
}
