package lintcode;

/**
 * @author Legend
 * @data by on 19-5-3.
 * @description driving-problem
 * idea:
 *      Union Find 这题是小车能不能通过 可以把问题装化为 几种情况下无法通过的路是否连通
 *      也就是3种情况 1障碍物上方无法通过 2下方无法通过 3两个障碍物中间无法通过 因为小车半径为2 障碍物半径为1
 *      因此 前面两种情况是当障碍物到路边的距离<=5(障碍物半径1+小车直径4)时 小车无法通过
 *      第3种情况 也就是两个障碍物之间的距离<=6(两个障碍物半径2 + 小车直径4) 小车无法通过
 *      那么最后要解决的问题是 如何让他们连通？ 如果是第3种情况，直径把障碍物对应的[索引]连通即可
 *      如果是前面两种情况，需要借助一个辅助节点 对于上方无法通过的 直接把[障碍物索引]和障碍物数量n连通；对于下方 直接和n+1连通.
 *      那么最后怎样知道小车能不能通过呢？ 直接判断n和n+1是否连通 即可 n和n+1连通就意味着 要么直接一个障碍物在道路中间
 *      使得小车无法从上或小通过，要么就是两个障碍物中间无法通过 否则n和n+1不会连通
 */
public class Test1628 {

    public String drivingProblem(int L, int W, double[][] p) {
        int n = p.length;
        UnionFind union = new UnionFind(n + 2);
        for (int i = 0;i < n;i++) {
            for (int j = i+1;j < n;j++) {
                double dx = Math.pow(p[j][0] - p[i][0], 2);
                double dy = Math.pow(p[j][1] - p[i][1], 2);
                if (dx + dy <= 36.0) union.union(i, j);
            }
            if (p[i][1] <= 5) union.union(i, n);
            if (W-p[i][1] <= 5) union.union(i, n+1);
        }
        return union.find(n) == union.find(n+1) ? "no" : "yes";
    }

    class UnionFind {
        int parent[];
        UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0;i < n;i++) parent[i] = i;
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                parent[pRoot] = qRoot;
            }
        }
    }
}
