package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-4-30.
 * @description deliver-the-message
 */
public class Test972 {

    public int deliverMessage(int[] t, int[][] subordinate) {
        int result = 0;
        int[] visited = new int[t.length + 1];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0;i < subordinate[cur].length;i++) {
                int v = subordinate[cur][i];
                if (v != -1 && visited[v] == -1) {
                    visited[v] = visited[cur] + t[cur];
                    result = Math.max(result, visited[v]);
                    queue.offer(v);
                }
            }
        }
        return result;
    }
}
