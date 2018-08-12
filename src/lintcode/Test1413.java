package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-15.
 * @description tree
 */
public class Test1413 {

    private int[] parent;
    private List<Integer>[] lists;
    public int[] tree(int[] x, int[] y, int[] a, int[] b) {
        // Write your code here
        int n = x.length+1;
        lists = new List[n+1];
        parent = new int[n+1];
        for (int i=1;i<=n;i++) lists[i] = new ArrayList<>();
        for (int i=0;i<x.length;i++) {
            lists[x[i]].add(y[i]);
            lists[y[i]].add(x[i]);
        }
        dfs(1, 0);
        int[] result = new int[a.length];
        for (int i=0;i<a.length;i++) {
            int p = a[i], q = b[i];
            if (parent[p]==q || parent[q]==p) result[i] = 2;
            else if (parent[p] == parent[q]) result[i] = 1;
        }
        return result;
    }

    private void dfs(int node, int father) {
        parent[node] = father;
        for (int i: lists[node]) {
            if (i != father) {
                dfs(i, node);
            }
        }
    }
}
