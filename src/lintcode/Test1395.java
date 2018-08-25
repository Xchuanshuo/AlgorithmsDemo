package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-25.
 * @description the-barycentre-of-the-trees
 * idea:
 *      dfs + 分治 这道题是要把树转化为图 然后使用dfs进行图的遍历 然后要用一个数组记录
 *      每个节点子树的节点数
 *
 */
public class Test1395 {

    private int resultNode, resultSize;
    private List<List<Integer>> graph;
    public int getBarycentre(int[] x, int[] y) {
        // Write your code here
        resultNode = 0;
        resultSize = x.length+2;
        int[] dp = new int[x.length+2];
        graph = new ArrayList<>();
        for (int i=0;i<x.length+2;i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<x.length;i++) {
            graph.get(x[i]).add(y[i]);
            graph.get(y[i]).add(x[i]);
        }
        dfs(1, 0, x.length+1, dp);
        return resultNode;
    }

    private void dfs(int x, int parent, int n, int[] dp) {
        dp[x] = 1;
        int maxSubTree = 0;
        for (int i=0;i<graph.get(x).size();i++) {
            int y = graph.get(x).get(i);
            if (y == parent) continue;
            dfs(y, x, n, dp);
            dp[x] += dp[y];
            maxSubTree = Math.max(maxSubTree, dp[y]);
        }
        maxSubTree = Math.max(maxSubTree, n-dp[x]);
        if (maxSubTree<resultSize || (maxSubTree==resultSize && x<resultNode)) {
            resultSize = maxSubTree;
            resultNode = x;
        }
    }
}
