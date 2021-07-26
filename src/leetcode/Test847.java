package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-6-23.
 * @description https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/
 * idea:
 *      BFS, 使用一个visited[i][j]来记录出发点为i,状态为j的情况是否已经访问过
 *      状态j记录了哪些节点已经访问过
 */
public class Test847 {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] visited = new boolean[n][1<<n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0;i < n;i++) {
            q.offer(new int[]{i, 1 << i});
            visited[i][1<<i] = true;
        }
        int end = (1 << n) - 1, step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0;i < size;i++) {
                int[] s = q.poll();
                for (int t : graph[s[0]]) {
                    int state = s[1] | (1<<t);
                    if (state == end) return step;
                    if (visited[t][state]) continue;
                    visited[t][state] = true;
                    q.offer(new int[]{t, state});
                }
            }
        }
        return 0;
    }
}
