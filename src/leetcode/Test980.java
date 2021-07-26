package leetcode;

/**
 * @author Legend
 * @data by on 2021/7/26.
 * @description https://leetcode-cn.com/problems/unique-paths-iii/
 * idea:
 *      哈密尔顿路径, 求经过所有点的路径数 因为m*n<=20
 *      所以对于节点是否访问过的数组可以进行状态压缩
 */
public class Test980 {


    int[][] grid;
    int m, n, end;
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int total = m * n, start = -1;
        int visited = 0;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] == -1) {
                    total--;
                } else if (grid[i][j] == 1) {
                    start = i * n + j; grid[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    end = i * n + j; grid[i][j] = 0;
                }
            }
        }
        return dfs(start, total - 1, visited);
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int dfs(int s, int left, int visited) {
        int x = s/n, y = s%n;
        visited |= 1 << s;
        if (left == 0 && s == end) return 1;
        int res = 0;
        for (int i = 0;i < 4;i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            int pos = nx*n + ny;
            if (isValid(nx, ny) && grid[nx][ny] != -1 && (visited&(1<<pos)) == 0) {
                res += dfs(pos, left - 1, visited);
            }
        }
        return res;
    }

    private boolean isValid(int x, int y) {
        return x>=0 && x<m && y>=0 && y<n;
    }
}
