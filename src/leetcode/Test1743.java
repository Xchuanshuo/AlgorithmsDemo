package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-25.
 * @description https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/
 */
public class Test1743 {

    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] a : adjacentPairs) {
            if (!graph.containsKey(a[0])) graph.put(a[0], new LinkedList<>());
            if (!graph.containsKey(a[1])) graph.put(a[1], new LinkedList<>());
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }
        int[] res = new int[len+1];
        boolean[] visited = new boolean[200005];
        for (Map.Entry<Integer, List<Integer>> e: graph.entrySet())
            if (e.getValue().size() == 1) {
                res[0] = e.getKey();
                visited[res[0] + 100001] = true;
                break;
            }
        for (int i = 1;i < res.length;i++) {
            List<Integer> points = graph.get(res[i-1]);
            for (int p : points) {
                if (visited[p + 100001]) continue;
                res[i] = p; break;
            }
            visited[res[i] + 100001] = true;
        }
        return res;
    }
}
