package leetcode;

import java.util.*;
import java.util.concurrent.Future;

/**
 * @author Legend
 * @data by on 21-9-2.
 * @description https://leetcode-cn.com/problems/reconstruct-itinerary/
 * idea:
 *      Hierholzer算法求解欧拉路径
 */
public class Test332 {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!graph.containsKey(from)) graph.put(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }
        dfs("JFK", graph, result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(String from, Map<String, Queue<String>> graph, List<String> result) {
        while (graph.containsKey(from) && graph.get(from).size() > 0) {
            String next = graph.get(from).poll();
            dfs(next, graph, result);
        }
        result.add(from);
    }
}
