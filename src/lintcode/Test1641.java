package lintcode;

/**
 * @author Legend
 * @data by on 19-5-2.
 * @description max-remove-order
 * idea:
 *      Union Find 没想到 重点是把问题转换 同行或同列有多个1可删除 -> 同行或同列合并多个1 关键这里的union的条件
 *      是同行或同列为1只要满足条件 中间是否隔了0没有影响 合并就可以用并查集, 合并后 只有他们的祖先节点是不能删除的
 *      用值为1的总数 减去 祖先数量 即可得出结果
 */
public class Test1641 {

    int[] parent = new int[5005];
    int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return parent[p];
    }

    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        parent[pRoot] = qRoot;
    }

    public int getAns(int[][] mp) {
        int m = mp.length, n = mp[0].length;
        int[] row = new int[m];
        int[] column = new int[n];
        int count = 0;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (mp[i][j] == 1) {
                    int pos = i * n + j + 1;
                    parent[pos] = pos;
                    row[i] = column[j] = pos;
                    count++;
                }
            }
        }
        for (int i = 0;i < m;i++) {
            for (int j = 0; j < n; j++) {
                if (mp[i][j] == 1) {
                    union(i * n + j + 1, row[i]);
                    union(i * n + j + 1, column[j]);
                }
            }
        }
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (mp[i][j] == 1 && parent[i*n+j+1] == i * n + j + 1) {
                    count--;
                }
            }
        }
        return count;
    }
}
