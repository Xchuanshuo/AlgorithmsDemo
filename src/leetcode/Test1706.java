package leetcode;

/**
 * @author Legend
 * @data by on 21-5-18.
 * @description https://leetcode-cn.com/problems/where-will-the-ball-fall/
 */
public class Test1706 {

    int m, n;
    public int[] findBall(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0;i < n;i++) {
            res[i] = dfs(0, i, grid);
        }
        return res;
    }

    private int dfs(int x, int y, int[][] grid) {
        if (x == m) return y;
        if (y == 0 && grid[x][y] == -1) return -1;
        if (y == n - 1 && grid[x][y] == 1) return -1;
        if (grid[x][y] == 1 && y < n-1 && grid[x][y+1] == 1) {
            return dfs(x+1, y+1, grid);
        }
        if (grid[x][y] == -1 && y-1>=0 && grid[x][y-1] == -1) {
            return dfs(x+1, y-1, grid);
        }
        return -1;
    }
}
