package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-11.
 * @description https://leetcode-cn.com/problems/minimum-cost-to-reach-destination-in-time/
 * idea:
 *      dp[t][i] 表示花费时间t,到达顶点i的最小费用
 *      枚举所有顶点i, 以及顶点i的相邻顶点v
 *      dp[t][i] = min(dp[t][i],dp[t-w][v] + f[i])
 *      即 花费时间t,到顶点i的最小费用为 花费时间t-w,到顶点v的最小费用 + 到达i的同行费
 *
 *      初始条件: dp[t][0] = f[0], 即 任意时间t到达起点的费用为f[0]
 *      结果: min(dp[1][n-1],dp[2][n-1],...,dp[time][n-1])
 */
public class Test5795 {

    public int minCost(int time, int[][] edges, int[] f) {
        int n = f.length;
        Map<Integer, List<Point>> graph = new HashMap<>();
        for (int[] e : edges) {
            if (!graph.containsKey(e[0])) {
                graph.put(e[0], new LinkedList<>());
            }
            if (!graph.containsKey(e[1])) {
                graph.put(e[1], new LinkedList<>());
            }
            graph.get(e[0]).add(new Point(e[1], e[2]));
            graph.get(e[1]).add(new Point(e[0], e[2]));
        }
        int INF = (int)1e9;
        int[][] dp = new int[time+1][n];
        for (int[] d : dp) Arrays.fill(d, INF);
        for (int t = 0;t <= time;t++) {
            dp[t][0] = f[0];
            for (int i = 0;i < n;i++) {
                for (Point p: graph.get(i)) {
                    if (t-p.w >= 0) {
                        dp[t][i] = Math.min(dp[t][i], dp[t-p.w][p.v] + f[i]);
                    }
                }
            }
        }
        int res = INF;
        for (int i = 1;i <= time;i++) {
            res = Math.min(res, dp[i][n-1]);
        }
        return res == INF ? -1 : res;
    }

    private class Point {
        int v, w;
        Point(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
