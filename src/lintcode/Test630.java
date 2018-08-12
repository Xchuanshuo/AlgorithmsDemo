package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-8-12.
 * @description knight-shortest-path-ii
 */
public class Test630 {

    public int shortestPath2(boolean[][] grid) {
        // write your code here
        if (grid==null || grid.length==0) return -1;
        int row=grid.length, col = grid[0].length, result=0;
        int[][] dirs = {{1, 2}, {-1, 2}, {2, 1}, {-2, 1}};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        grid[0][0] = true;
        while (!queue.isEmpty()) {
            result++;
            int len = queue.size();
            for (int i=0;i<len;i++) {
                Point point = queue.poll();
                for (int j=0;j<4;j++) {
                    int newX = point.x + dirs[j][0];
                    int newY = point.y + dirs[j][1];
                    if (newX>=0 && newX<row && newY>=0 && newY<col && !grid[newX][newY]) {
                        grid[newX][newY] = true;
                        if (newX==row-1 && newY==col-1) return result;
                        queue.offer(new Point(newX, newY));
                    }
                }
            }
        }
        return -1;
    }

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
