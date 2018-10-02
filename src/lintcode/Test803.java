package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description shortest-distance-form-all-building
 * idea:
 *      与Test573一样 反向bfs
 */
public class Test803 {

    private int result = Integer.MAX_VALUE;
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int buildingCount = 0;
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid==null || grid.length==0) return -1;
        for (int[] arr: grid) {
            for (int i: arr) {
                if (i == 1) buildingCount++;
            }
        }
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                bfs(i, j, grid);
            }
        }
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    private void bfs(int x, int y, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        int curRes = 0, distance=0, curBuilding=0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j=0;j<len;j++) {
                Point point = queue.poll();
                for (int i=0;i<4;i++) {
                    int newX = point.x + dirs[i][0];
                    int newY = point.y + dirs[i][1];
                    if (newX>=0 && newX<m && newY>=0 && newY<n && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        if (grid[newX][newY] == 0) {
                            queue.offer(new Point(newX, newY));
                        } else if (grid[newX][newY] == 1) {
                            curRes += distance;
                            curBuilding++;
                            if (curRes > result) break;
                        }
                    }
                }
                distance++;
            }
        }
        if (curBuilding==buildingCount && curRes<result) {
            result = curRes;
        }
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
