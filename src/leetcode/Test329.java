package leetcode;

/**
 * @author Legend
 * @data by on 21-6-26.
 * @description https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * idea:
 *      dfs + 记忆化搜索
 */
public class Test329 {

    int m, n;
    int[][] mat;
    public int longestIncreasingPath(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.mat = mat;
        int[][] mem = new int[m][n];
        int max = 1;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                max = Math.max(max, dfs(i, j, -1, mem));
            }
        }
        return max;
    }

    private int dfs(int x, int y, int last, int[][] memo) {
        if (x < 0 || x >= m || y < 0 || y >= n || last >= mat[x][y]) return 0;
        if (memo[x][y] != 0) return memo[x][y];
        int res = 0, cur = mat[x][y];
        res = 1 + Math.max(
                Math.max(dfs(x+1, y, cur, memo), dfs(x, y + 1, cur, memo)),
                Math.max(dfs(x-1, y, cur, memo), dfs(x, y - 1, cur, memo))
        );
        memo[x][y] = res;
        return res;
    }
}
