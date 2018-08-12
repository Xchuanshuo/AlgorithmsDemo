package unionfind;

/**
 * @author Legend
 * @data by on 18-7-30.
 * @description
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        this.id = new int[size];
        for (int i=0;i<id.length;i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        if (p<0 || p>getSize()) {
            throw new IllegalArgumentException("p out of bond.");
        }
        return id[p];
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i=0;i<getSize();i++) {
            if (id[i] == pId) id[i] = qId;
        }
    }
}
