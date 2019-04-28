package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-4-29.
 * @description minimum-height-trees
 */
public class Test1298 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges==null || edges.length==0) return Collections.singletonList(0);
        int[] degree = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0;i < n;i++) list.add(new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];
            degree[u]++;
            degree[v]++;
            list.get(u).add(v);
            list.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i < n;i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        List<Integer> result = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result = new ArrayList<>();
            for (int i = 0;i < size;i++) {
                int cur = queue.poll();
                result.add(cur);
                for (int v : list.get(cur)) {
                    if (--degree[v] == 1) queue.offer(v);
                }
            }
        }
        return result;
    }
}
