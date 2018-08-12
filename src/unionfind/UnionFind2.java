package unionfind;

/**
 * @author Legend
 * @data by on 18-7-30.
 * @description
 */
public class UnionFind2 implements UF {

    private int[] parent;
    // sz[i]表示以i为结点的树的根节点个数
    private int[] sz;

    public UnionFind2(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i=0;i<size;i++) {
            parent[i] = i;
            sz[i] = 1;
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
    private int find(int p) {
        if (p<0 || p>getSize()) {
            throw new IllegalArgumentException("p is out of bond.");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return parent[p];
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
