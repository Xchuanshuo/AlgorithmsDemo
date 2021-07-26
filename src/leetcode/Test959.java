package leetcode;

/**
 * @author Legend
 * @data by on 21-5-22.
 * @description https://leetcode-cn.com/problems/regions-cut-by-slashes/submissions/
 * idea:
 *      把每个位置作为一个矩形划分为4个区域 使用并查集
 */
public class Test959 {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        UF uf = new UF(size);
        for (int r = 0;r < n;r++) {
            for (int c = 0;c < n;c++) {
                int seat = r*n*4 + c*4;
                switch (grid[r].charAt(c)) {
                    case ' ':
                        uf.union(seat, seat+1);
                        uf.union(seat+1, seat+2);
                        uf.union(seat+2, seat+3);
                        break;
                    case '/':
                        uf.union(seat, seat+3);
                        uf.union(seat+1, seat+2);
                        break;
                    case '\\':
                        uf.union(seat,seat+1);
                        uf.union(seat+2, seat+3);
                        break;
                }
                if (r < n-1) uf.union(seat+2, seat + n*4);
                if (c < n-1) uf.union(seat+1, seat + 4 +3);
            }
        }
        return uf.getCount();
    }

    class UF {
        int[] parent;
        int cnt = 0;
        public UF(int size) {
            this.parent = new int[size];
            for (int i = 0;i < size;i++) {
                parent[i] = i;
            }
            this.cnt = size;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            parent[pRoot] = qRoot;
            cnt--;
        }

        public int getCount() {
            return cnt;
        }
    }
}
