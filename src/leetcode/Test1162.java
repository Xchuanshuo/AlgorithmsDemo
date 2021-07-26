package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 21-6-24.
 * @description https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * idea:
 *      BFS 从所有陆地出发, 最后访问到的海洋即是距离陆地最近的海洋
 */
public class Test1162 {

    public int maxDistance(int[][] grid) {
        int m = grid.length,  n = grid[0].length;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] == 1) q.offer(new int[]{i,j});
            }
        }
        if (q.size() == 0 || q.size() == m*n) return -1;
        int step = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0;k < size;k++) {
                int[] cur = q.poll();
                for (int i = 0;i < 4;i++) {
                    int nx = cur[0] + dirs[i][0];
                    int ny = cur[1] + dirs[i][1];
                    if (nx >= m || nx < 0 || ny < 0 || ny >= n || grid[nx][ny]!=0) {
                        continue;
                    }
                    grid[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
            step++;
        }
        return step;
    }
}
