package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-6-28.
 * @description https://leetcode-cn.com/problems/bus-routes
 */
public class Test815 {

//    public int numBusesToDestination(int[][] routes, int source, int target) {
//        int n = routes.length;
//        if (source == target) return 0;
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 0;i < n;i++) {
//            int[] route = routes[i];
//            for (int r : route) {
//                if (!graph.containsKey(r)) {
//                    graph.put(r, new ArrayList<>());
//                }
//                graph.get(r).add(i);
//            }
//        }
//        boolean[] visited = new boolean[n];
//        Queue<Integer> q =  new LinkedList<>();
//        q.offer(source);
//        for (int bus : graph.get(source)) {
//            visited[bus] = true;
//            for (int s : routes[bus]) q.offer(s);
//        }
//        int step = 0;
//        while (!q.isEmpty()) {
//            step++;
//            int size = q.size();
//            for (int k = 0;k < size;k++) {
//                int station = q.poll();
//                if (station == target) return step;
//                for (int bus: graph.get(station)) {
//                    if (visited[bus]) continue;
//                    visited[bus] = true;
//                    for (int next : routes[bus]) {
//                        q.offer(next);
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        if (source == target) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0;i < n;i++) {
            int[] route = routes[i];
            for (int r : route) {
                if (!graph.containsKey(r)) {
                    graph.put(r, new ArrayList<>());
                }
                graph.get(r).add(i);
            }
        }
        boolean[] visited = new boolean[n];
        Set<Integer> q1 = new HashSet<>();
        Set<Integer> q2 = new HashSet<>();
        q1.add(source); q2.add(target);
        int step = 0;
        while (!q1.isEmpty()) {
            step++;
            Set<Integer> temp = new HashSet<>();
            for (int station : q1) {
                if (!graph.containsKey(station)) continue;
                for (int bus: graph.get(station)) {
                    if (visited[bus]) continue;
                    visited[bus] = true;
                    for (int next : routes[bus]) {
                        if (q2.contains(next)) return step;
                        temp.add(next);
                    }
                }
            }
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
}
