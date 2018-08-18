package lintcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description social-network
 * idea:
 *      这道题方法很多　可以用去构造一张图　不过这里用union-find更加快
 *
 */
public class Test1569 {

    private int[] size;
    private int[] parent;
    public String socialNetwork(int n, int[] a, int[] b) {
        // Write your code here
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i=0;i<a.length;i++) {
            union(a[i], b[i]);
        }
        if (size[find(n)] == n) return "yes";
        return "no";
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return parent[p];
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
