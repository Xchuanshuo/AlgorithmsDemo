package lintcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description 4-way-unique-paths
 * idea:
 *      dfs
 */
public class Test795 {

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int result = 0;
    public int uniquePaths(int m, int n) {
        // Write your code here
        boolean[][] visited = new boolean[m][n];
        visited[m-1][n-1] = true;
        dfs(m-1, n-1, visited);
        return result;
    }

    private void dfs(int x, int y, boolean visited[][]) {
        if (x==0 && y==0) {
            result++;
            return;
        }
        for (int j=0;j<4;j++) {
            int newX = x + dirs[j][0];
            int newY = y + dirs[j][1];
            if (newX>=0 && newX<visited.length && newY>=0 && newY<visited[0].length && !visited[newX][newY]) {
                visited[newX][newY] = true;
                dfs(newX, newY, visited);
                visited[newX][newY] = false;
            }
        }
    }
}
