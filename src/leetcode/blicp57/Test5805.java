package leetcode.blicp57;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-7-25.
 * @description
 */
public class Test5805 {

    public int smallestChair(int[][] times, int target) {
        int n = times.length, arrival = times[target][0];
        List<Point> pointList = new ArrayList<>();
        for (int i = 0;i < times.length;i++) {
            int[] time = times[i];
            pointList.add(new Point(i, time[0], 1));
            pointList.add(new Point(i, time[1], -1));
        }
        pointList.sort((o1, o2) -> {
            if (o1.pos == o2.pos) return o1.val - o2.val;
            return o1.pos - o2.pos;
        });
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> alloc = new TreeSet<>();
        for (int i = 0;i < n;i++) alloc.add(i);
        for (Point p : pointList) {
            Integer min = alloc.first();
            if (p.val > 0) {
                alloc.remove(min);
                map.put(p.id, min);
            } else {
                alloc.add(map.get(p.id));
            }
            if (arrival == p.pos && p.val > 0) return min;
        }
        return alloc.first();
    }

    class Point {
        int id,pos, val;
        public Point(int id, int pos, int val) {
            this.id = id;
            this.pos = pos;
            this.val= val;
        }
    }
}
