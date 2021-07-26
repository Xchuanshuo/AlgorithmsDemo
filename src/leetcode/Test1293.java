package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-5-11.
 * @description https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/\
 * idea:
 *      求最短路径直接用bfs, 最多可以消除障碍物k次, 多加一个变量记录走到当前点已经使用的次数
 */
public class Test1293 {

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k+1];
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        visited[0][0][0] = true;
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int j = 0;j < size;j++) {
                Point cur = q.poll();
                if (cur.x == m - 1 && cur.y == n - 1) return res - 1;
                for (int i = 0;i < 4;i++) {
                    int nx = cur.x + dirs[i][0];
                    int ny = cur.y + dirs[i][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    int cnt = cur.cnt + (grid[nx][ny] == 1 ? 1 : 0);
                    if (cnt <= k && !visited[nx][ny][cnt]) {
                        visited[nx][ny][cnt] = true;
                        q.offer(new Point(nx, ny, cnt));
                    }
                }
            }
        }
        return -1;
    }

    class Point {
        int x, y;
        int cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
