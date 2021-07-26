package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Legend
 * @data by on 21-6-27.
 * @description https://leetcode-cn.com/problems/my-calendar-iii/
 */
public class Test732 {

    class MyCalendarThree {

        Map<Integer, Integer> map;
        public MyCalendarThree() {
            this.map = new TreeMap<>();
        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int max = 0, cur = 0;
            for (int v : map.values()) {
                cur += v;
                max = Math.max(max, cur);
            }
            return max;
        }
    }

}
