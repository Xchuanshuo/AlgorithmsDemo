package lintcode;

import java.util.PriorityQueue;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description minimum-difference
 * idea:
 *      优先队列 violent to solve
 */
public class Test1566 {

    public int minimumDifference(int[][] array) {
        // Write your code here
        int m = array.length, n = array[0].length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i=0;i<m;i++) {
            max = Math.max(max, array[i][0]);
            pq.offer(new Point(i, 0, array[i][0]));
        }
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            int x = point.x, y = point.y;
            result = Math.min(result, max-point.val);
            if (y+1==n) break;
            pq.offer(new Point(x, y+1, array[x][y+1]));
            max = Math.max(max, array[x][y+1]);
        }
        return result;
    }

    class Point implements Comparable<Point> {
        int x, y, val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return this.val-o.val;
        }
    }
}
