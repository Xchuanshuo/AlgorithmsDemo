package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-6-10.
 * @description
 */
public class Test920 {

    public boolean canAttendMeetings(List<Interval> intervals) {
        Map<Integer, Integer> maps = new TreeMap<>();
        for (Interval i: intervals) {
            maps.put(i.start, maps.getOrDefault(i.start,0)+1);
            maps.put(i.end, maps.getOrDefault(i.end, 0)-1);
        }
        int cnt = 0;
        for (int m:maps.values()) {
            cnt += m;
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(0, 30);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        Test920 test920 = new Test920();
        System.out.println(test920.canAttendMeetings(intervals));
    }
}
