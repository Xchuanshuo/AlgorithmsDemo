package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-10-6.
 * @description maximum-product-path
 * idea:
 *      首先保存每一条路径 然后使用dfs进行遍历 因为统计的是从根节点到叶子节点
 *      的权值乘积 所以dfs到叶子节点时才能进行乘积大小的比较 那么如何判断一个节点
 *      是否是叶子节点呢？可以用一个boolean变量来保存 默认是叶子节点 如果以当前节点
 *      还存在孩子节点 则当前节点就肯定不为叶子节点 过程中还有需要注意的就是计算时使用
 *      long变量 防止数值过大 int溢出
 */
public class Test1403 {

    private static final int MOD = 1000000007;
    private long result = Integer.MIN_VALUE;
    private List<List<Integer>> graph = new ArrayList<>();

    public int getProduct(int[] x, int[] y, int[] d) {
        // Write your code here
        for (int i=0;i<=x.length+1;i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<x.length;i++) {
            graph.get(x[i]).add(y[i]);
            graph.get(y[i]).add(x[i]);
        }
        dfs(1, 0, 1, d);
        return (int) result;
    }

    private void dfs(int cur, int pre, long mul, int[] d) {
        boolean isLeaf = true;
        long now = (mul*d[cur-1]%MOD + MOD) % MOD;
        for (int i=0;i<graph.get(cur).size();i++) {
            int v = graph.get(cur).get(i);
            if (v == pre) continue;
            isLeaf = false;
            dfs(v, cur, now, d);
        }
        if (isLeaf) {
            result = Math.max(result, now);
        }
    }
}
