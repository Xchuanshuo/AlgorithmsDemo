package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-4-29.
 * @description friends-within-tree-jumps
 */
public class Test932 {

    public int[] withinThreeJumps(int[] a, int[] b, int[] c, int[] d) {
        // Write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0;i < a.length;i++) {
            map.putIfAbsent(a[i], new ArrayList<>());
            map.putIfAbsent(b[i], new ArrayList<>());
            map.getOrDefault(a[i], new ArrayList<>()).add(b[i]);
            map.getOrDefault(b[i], new ArrayList<>()).add(a[i]);
        }
        int[] result = new int[c.length];
        for (int i = 0;i < c.length;i++) {
            result[i] = bfs(map, c[i], d[i]);
        }
        return result;
    }

    private int bfs(Map<Integer, List<Integer>> map, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                int cur = queue.poll();
                for (int f : map.getOrDefault(cur, new ArrayList<>())) {
                    if (f == end) return count <= 3 ? 1 : 0;
                    if (!set.contains(f)) {
                        queue.offer(f);
                        set.add(f);
                    }
                }
            }
        }
        return 0;
    }
}
