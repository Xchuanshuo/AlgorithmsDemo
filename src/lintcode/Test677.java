package lintcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 20-1-17.
 * @description number-of-big-islands
 */
public class Test677 {

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        if (grid == null || grid[0].length == 0) return 0;
        int r = grid.length, c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int result = 0;
        for (int i = 0;i < r;i++) {
            for (int j = 0;j < c;j++) {
                if (!visited[i][j] && grid[i][j]
                        && isBig(visited, grid, new Point(i, j), k)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isBig(boolean[][] visited, boolean[][] grid, Point p, int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        visited[p.x][p.y] = true;
        int len = 0;
        while (!queue.isEmpty()) {
            Point curP = queue.poll();
            len++;
            for (int j = 0;j < 4;j++) {
                int newX = curP.x + dirs[j][0];
                int newY = curP.y + dirs[j][1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                        && grid[newX][newY] && !visited[newX][newY]) {
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        return len >= k;
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}