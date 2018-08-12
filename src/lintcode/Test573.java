package lintcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-8-2.
 * @description build-post-office-ii
 */
public class Test573 {

    private int houses, col, row, result=Integer.MAX_VALUE;
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid==null || grid.length == 0) return -1;
        row = grid.length;
        col = grid[0].length;
        for (int[] arr: grid) {
            for (int a: arr) {
                if (a == 1) houses++;
            }
        }
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == 0) {
                    bfs(i, j, grid);
                }
            }
        }
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    private void bfs(int x, int y, int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        int visitedHouse = 0, res=0, distance=1;
        boolean[] visited = new boolean[row*col];
        visited[x*col+y] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i=0;i<len;i++) {
                Point point = queue.poll();
                for (int j=0;j<4;j++) {
                    int newX = point.x + dirs[j][0];
                    int newY = point.y + dirs[j][1];
                    if (newX>=0 && newY>=0 && newX<row && newY<col && !visited[newX*col+newY]) {
                        visited[newX*col+newY] = true;
                        if (grid[newX][newY] == 0) {
                            queue.offer(new Point(newX, newY));
                        } else if (grid[newX][newY] == 1) {
                            res += distance;
                            visitedHouse++;
                            if (res > result) return;
                        }
                    }
                }
            }
            distance++;
        }
        if (visitedHouse==houses && res<result) result = res;
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
    }
}
