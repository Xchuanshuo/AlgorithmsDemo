package lintcode;
import jdk.nashorn.api.tree.ForOfLoopTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-7-31.
 * @description surrounded-regions
 */
public class Test477 {

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int[] dirs[] = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private int m, n;
    public void surroundedRegions(char[][] board) {
        // write your code here
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        for (int i=0;i<m;i++) {
            bfs(board, i, 0);
            bfs(board, i, n-1);
        }
        for (int i=0;i<n;i++) {
            bfs(board, 0, i);
            bfs(board, m-1, i);
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {
        if (board[x][y] != 'O') return;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 'W';
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i=0;i<4;i++) {
                int newX = point.x + dirs[i][0];
                int newY = point.y + dirs[i][1];
                if (newX>=0 && newX<m && newY>=0 && newY<n
                        && board[newX][newY] == 'O') {
                    board[newX][newY] = 'W';
                    queue.offer(new Point(newX, newY));
                }
            }
        }
    }
}
