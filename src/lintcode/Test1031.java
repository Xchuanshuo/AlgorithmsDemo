package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-9-27.
 * @description is-graph-bipartite
 * idea:
 *      bfs 这题看图是否能被分成两部分 所以遍历的时候使用一个trick 如果未访问 就把
 *      相邻的两个点染成相反的颜色 这里就用-1*来表示 这样的话如果遍历完所有点 都是
 *      相邻两点颜色相反 就说明该图能够被分成不相交的两部分 否则 如果点被访问过时
 *      并且相邻的点颜色一样 就说明该图肯定存在相交的情况
 */
public class Test1031 {

    public boolean isBipartite(int[][] graph) {
        // Write your code here
        if (graph==null || graph.length==0) return false;
        int n = graph.length;
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            if (visited[i] != 0) continue;
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                int pre = queue.poll();
                for (int j=0;j<graph[pre].length;j++) {
                    int cur = graph[pre][j];
                    if (visited[cur]==0) {
                        visited[cur] = -1*visited[pre];
                        queue.offer(cur);
                        continue;
                    }
                    if (visited[pre] != -1*visited[cur]) return false;
                }
            }
        }
        return true;
    }
}
