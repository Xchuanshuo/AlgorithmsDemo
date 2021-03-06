package lintcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-10-1.
 * @description shortest-distance-in-3d-space
 * idea:
 *      bfs 过程中把障碍物当作访问过的点进行过滤即可
 */
public class Test1374 {

    private final int[][] pos = {{1,0,0}, {0,1,0}, {0,0,1},
                            {-1,0,0}, {0,-1,0}, {0,0,-1}};
    private int n = 0;
    public int shortestDistance(int N, int[][] barriers) {
        // Write your code here
        if (N<=0) return -1;
        this.n = N;
        int step = 0;
        Queue<Point> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int[] arr: barriers) {
            String str = ""+arr[0]+arr[1]+arr[2];
            visited.add(str);
        }
        Point start = new Point(0,0,0);
        queue.add(start);
        visited.add(start.toString());
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j=0;j<len;j++) {
                Point point = queue.poll();
                if (isEnd(point.x, point.y, point.z)) return step;
                for (int i=0;i<6;i++) {
                    int newX = point.x + pos[i][0];
                    int newY = point.y + pos[i][1];
                    int newZ = point.z + pos[i][2];
                    if (!inBound(newX, newY, newZ)) continue;
                    Point newPoint = new Point(newX, newY, newZ);
                    if (!visited.contains(newPoint.toString())) {
                        queue.offer(newPoint);
                        visited.add(newPoint.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean isEnd(int x, int y, int z) {
        if (x==n-1 && y==n-1 && z==n-1) {
            return true;
        }
        return false;
    }

    private boolean inBound(int x, int y, int z) {
        if (x<0 || x>=n || y<0 || y>=n || z<0 || z>=n) {
            return false;
        }
        return true;
    }

    class Point {
        int x, y, z;
        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return ""+x+y+z;
        }
    }
}
