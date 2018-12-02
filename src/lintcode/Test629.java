package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-12-2.
 * @description minimum-spanning-tree
 * idea:
 *      最小生成树->Kruskal算法
 */
public class Test629 {

    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        Collections.sort(connections, cmp);
        Map<String, Integer> map = new HashMap<>();
        int n = 0;
        for (Connection connection: connections) {
            if (!map.containsKey(connection.city1)) {
                map.put(connection.city1, ++n);
            }
            if (!map.containsKey(connection.city2)) {
                map.put(connection.city2, ++n);
            }
        }
        int[] parent = new int[n+1];
        List<Connection> mstResult = new ArrayList<>();
        for (Connection connection: connections) {
            int p = map.get(connection.city1);
            int q = map.get(connection.city2);

            int pRoot = find(parent, p);
            int qRoot = find(parent, q);
            if (pRoot != qRoot) {
                parent[pRoot] = qRoot;
                mstResult.add(connection);
            }
        }
        if (mstResult.size() != n-1) {
            return new ArrayList<>();
        }
        return mstResult;
    }

    private int find(int[] parent, int p) {
        if (parent[p] == 0) {
            return p;
        }
        return parent[p] = find(parent, parent[p]);
    }

    static Comparator<Connection> cmp = ((o1, o2) -> {
        if (o1.cost != o2.cost) {
            return o1.cost - o2.cost;
        } else if (!o1.city1.equals(o2.city1)) {
            return o1.city1.compareTo(o1.city1);
        }
        return o1.city2.compareTo(o2.city2);
    });

    class Connection {
        String city1, city2;
        int cost;
    }
}
