package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-6-27.
 * @description　k-closest-points
 */
public class Test612 {

    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
//        Queue<Point> queue = new PriorityQueue<>(k, (o1, o2) ->
//                o1.x!=o2.x?o1.x-o2.x:o1.y-o2.y);
        Queue<Point> queue = new PriorityQueue<>(k, (o1, o2) -> {
            int diff = getInstance(o1, origin)-getInstance(o2, origin);
            if (diff==0) {
                diff = o1.x!=o2.x?o1.x-o2.x:o1.y-o2.y;
            }
            return diff;
        });
        for (int i=0;i<points.length;i++) {
            queue.add(points[i]);
        }
        Point[] result = new Point[k];
        for (int i=0;i<k;i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    private int getInstance(Point point, Point origin) {
        return (int) Math.pow(Math.pow(point.y-origin.y,2)+
                Math.pow(point.x-origin.x,2),1/2);
    }

    public static void main(String[] args) {
        Point[] points = new Point[5];
        points[0] = new Point(4, 6);
        points[1] = new Point(4, 7);
        points[2] = new Point(4, 4);
        points[3] = new Point(2, 5);
        points[4] = new Point(1, 1);
        Point origin = new Point(1, 0);
        Test612 test = new Test612();
        System.out.println(test.getInstance(points[4],origin));
        Point[] result = test.kClosest(points, origin, 3);
        for (Point point: result) {
            System.out.println("["+point.x+","+point.y+"]");
        }
    }
}
