package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-10-6.
 * @description 01-matrix-walking-problem
 * idea:
 *      正常情况下求解直接用bfs就好 但这道题有一个条件 能把某个障碍物边成通路, 所以
 *      要解这道题核心就是怎样去利用这一个条件 在以一个坐标开始去寻路时 有几种情况不
 *      继续走: 1.走到边界了 2.路上有障碍物 3.该点已经走过了 对于这道题 先看看前面两个
 *      条件都比较简单 第1个就不用说了，看看第2个 因为这里说了能把某个障碍物变成通路 那么
 *      在已经改变了前面的某个障碍物后 又碰到一个新的 此时不能再改变了 所以无法沿着这里继续走.
 *      最后重点就在于第3个条件 这里用一个数组visited[x][y][0]来记录 位置x,y是否访问过
 *      用[x][y][1]记录访问此节点的路径是否将障碍物变成过通路(1->0) 所以
 *          1.该位置访问过且未将1变成0(对于该点而言) 则该点视为已经访问过
 *          2.该位置访问过 且此路径有位置将1变为了0 也视为访问过
 */
public class Test1446 {

    private static final int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int m, n;
    public int getBestRoad(int[][] grid) {
        // Write your code here
        m = grid.length;
        n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, grid[0][0]==1));
        boolean[][][] visited = new boolean[m][n][2];
        visited[0][0][0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int k=0;k<len;k++) {
                Point point = queue.poll();
                if (point.x==m-1 && point.y==n-1) return step;
                for (int i=0;i<4;i++) {
                    int newX = point.x + dirs[i][0];
                    int newY = point.y + dirs[i][1];
                    if (newX<0 || newX>=m || newY<0 || newY>=n ||
                            visited(point.hasChange, visited, newX, newY)
                            || (point.hasChange && grid[newX][newY]==1)) {
                        continue;
                    }
                    visited[newX][newY][0] = true;
                    // 只有此前已经改变过并且当前不是障碍物 才视为该路径有1->0改变过
                    visited[newX][newY][1] = grid[newX][newY]!=1 && point.hasChange;
                    // 把位置放到队列时 看是否把1->0过 没改变过 并且当前点是1时 则视为改变了改点的1为0
                    queue.offer(new Point(newX, newY, grid[newX][newY]==1 || point.hasChange));
                }
            }
            step++;
        }
        return -1;
    }

    private boolean visited(boolean hasChange, boolean[][][] set, int newX, int newY) {
        return set[newX][newY][0] && (hasChange || !set[newX][newY][1]);
    }

    class Point {
        int x, y;
        boolean hasChange;

        Point(int x, int y, boolean hasChange) {
            this.x = x;
            this.y = y;
            this.hasChange = hasChange;
        }
    }
}
