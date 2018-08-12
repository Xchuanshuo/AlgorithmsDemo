package unionfind;

/**
 * @author Legend
 * @data by on 18-7-30.
 * @description
 */
public class UnionFind3 implements UF {

    private int[] parent;
    // rank[i]表示以i为结点的树的高度
    private int[] rank;

    public UnionFind3(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i=0;i<size;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 查询树中p结点的根结点
    // 基于路径压缩的优化
    private int find(int p) {
        if (p<0 || p>getSize()) {
            throw new IllegalArgumentException("p is out of bond.");
        }
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
//        if (p != parent[p]) {
//            parent[p] = find(parent[p]);
//        }
        return parent[p];
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }
}
