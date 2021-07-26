package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-5-30.
 * @description https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node/
 * idea:
 *      1.使用堆优化dijkstra算法求从[n点]出发到每个节点的最短路径
 *      2.要求从点1出发到点n的所有受限路径,受限路径定义为对于点i相邻节点j
 *        有 dst[j] > dst[i] 即从 n到点j的路径 + 点j到点i的路径为一条受限路径
 *        所以权值较小的路径一定由权值较大的路径转移过来, 因为最终是求到n的受限路径条数
 *        所以,求点n时需要保证其它节点的受限路径都已经求完 可以采用以下几步
 *
 *        (1) 将所有节点按最短路径从小到大排序
 *        (2) 定义dp[i]表示到节点i的受限路径条数， 若dst[j]>dst[i] 则 dp[i] += dp[j]
 *        (3) 初始条件: dp[1]=1, 即到节点1只有一条受限路径
 *            结果: dp[n]
 */
public class Test1786 {

    public int countRestrictedPaths(int n, int[][] edges) {
        int M = (int)1e9 + 7, INF =Integer.MAX_VALUE;
        List<List<Vertex>> graphs = new ArrayList<>(n+1);
        for (int i = 0;i <= n;i++) graphs.add(new ArrayList<>());
        for (int[] e : edges) {
            int v = e[0], w = e[1], val = e[2];
            graphs.get(v).add(new Vertex(w, val));
            graphs.get(w).add(new Vertex(v, val));
        }
        int[] dst = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dst, INF);
        dst[n] = 0;
        Queue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        pq.offer(new Vertex(n, 0));
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            for (Vertex w : graphs.get(cur.v)) {
                if (!visited[w.v]) {
                    if (dst[w.v] > dst[cur.v] + w.val) {
                        dst[w.v] = dst[cur.v] + w.val;
                        pq.offer(new Vertex(w.v, dst[w.v]));
                    }
                }
            }
        }
        Integer[] vs = new Integer[n+1];
        for (int i = 0;i <= n;i++) vs[i] = i;
        Arrays.sort(vs, (o1, o2) -> dst[o2] - dst[o1]);
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int v : vs) {
            for (Vertex w : graphs.get(v)) {
                if (dst[w.v] > dst[v]) {
                    dp[v] = (dp[v] + dp[w.v])%M;
                }
            }
        }
        return dp[n];
    }

    private class Vertex {
        int v, val;
        public Vertex(int v, int val) {
            this.v = v;
            this.val = val;
        }
    }
}
