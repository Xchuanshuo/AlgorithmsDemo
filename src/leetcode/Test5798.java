package leetcode;

/**
 * @author Legend
 * @data by on 21-6-27.
 * @description https://leetcode-cn.com/problems/cyclically-rotating-a-grid/
 */
public class Test5798 {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int min = Math.min(m, n);
        int rows = m, cols = n;
        for (int c = 0;c < min/2;c++) {
            int tk = k%((rows-2+cols)*2);
            int l = c, r = c + cols - 1, u = c, d = c + rows - 1;
            while (--tk >= 0) {
                int t = grid[c][c];
                for (int i = l;i < r;i++ ) {
                    grid[c][i] = grid[c][i+1];
                }
                for (int i = u;i < d;i++) {
                    grid[i][r] = grid[i+1][r];
                }
                for (int i = r;i > l;i--) {
                    grid[d][i] = grid[d][i-1];
                }
                for (int i = d;i > u;i--) {
                    grid[i][l] = grid[i-1][l];
                }
                grid[u+1][l] = t;
            }
            rows -= 2;
            cols -= 2;
        }
        return grid;
    }
}
