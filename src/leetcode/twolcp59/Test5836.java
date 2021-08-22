package leetcode.twolcp59;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-8-21.
 * @description https://leetcode-cn.com/contest/biweekly-contest-59/problems/number-of-ways-to-arrive-at-destination/
 * idea:
 *      需要考虑前面加入的节点 被后续更新的更加小, 此时该方案应该舍弃
 */
public class Test5836 {

    public int countPaths(int n, int[][] roads) {
        int M = (int) 1e9 + 7;
        long INF = (long) 1e16;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] r : roads) {
            int v = r[0], w = r[1], t = r[2];
            if (!graph.containsKey(v)) graph.put(v, new LinkedList<>());
            if (!graph.containsKey(w)) graph.put(w, new LinkedList<>());
            graph.get(v).add(new int[]{w, t});
            graph.get(w).add(new int[]{v, t});
        }
        long[] dist = new long[n]; // 从源点到任意点的最短路径
        Arrays.fill(dist, INF);
        int[] dp = new int[n]; // 到点n的最短路径方案数
        dist[0] = 0; dp[0] = 1;
        Queue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[1] - o2[1]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            int x = (int) p[0]; long d = p[1];
            // 需要考虑前面加入的节点 被后续更新的更加小, 此时该方案应该舍弃
            if (dist[x] < d || !graph.containsKey(x)) continue;
            for (int[] np : graph.get(x)) {
                int next = np[0], cost = np[1];
                if (dist[next] > dist[x] + cost) {
                    dist[next] = dist[x] + cost;
                    dp[next] = dp[x];
                    pq.offer(new long[]{next, dist[next]});
                } else if (dist[next] == dist[x] + cost) {
                    dp[next] = (dp[next] + dp[x])%M;
                }
            }
        }
        return dp[n-1];
    }
}
