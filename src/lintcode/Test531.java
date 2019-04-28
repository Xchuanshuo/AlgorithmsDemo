package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-4-28.
 * @description
 */
public class Test531 {

    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (s.label == t.label) return 0;
        int result = 0;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                UndirectedGraphNode graphNode = queue.poll();
                for (UndirectedGraphNode node : graphNode.neighbors) {
                    if (visited.contains(node)) continue;
                    if (node.label == t.label) return result;
                    queue.offer(node);
                    visited.add(node);
                }
            }
        }
        return -1;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
