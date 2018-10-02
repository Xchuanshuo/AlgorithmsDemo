package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description walls-and-gates
 */
public class Test663 {

    public void wallsAndGates(int[][] rooms) {
        // write your code here
        if (rooms==null || rooms.length==0) return;
        int row=rooms.length, col=rooms[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Point> queue = new LinkedList<>();
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i=0;i<4;i++) {
                int newX = point.x + dirs[i][0];
                int newY = point.y + dirs[i][1];
                if (newX>=0 && newX<row && newY>=0 && newY<col && rooms[newX][newY]==Integer.MAX_VALUE) {
                    rooms[newX][newY] = rooms[point.x][point.y] + 1;
                    queue.offer(new Point(newX, newY));
                }
            }
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
