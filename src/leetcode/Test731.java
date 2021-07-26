package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Legend
 * @data by on 21-6-27.
 * @description https://leetcode-cn.com/problems/my-calendar-ii/
 */
public class Test731 {

    class MyCalendarTwo {

        private Map<Integer, Integer> map;
        public MyCalendarTwo() {
            this.map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end , 0) - 1);
            int cnt = 0;
            for (int val : map.values()) {
                cnt += val;
                if (cnt >= 3) {
                    map.put(start, map.get(start) - 1);
                    map.put(end, map.get(end) + 1);
                    if (map.get(start) == 0) map.remove(start);
                    if (map.get(end) == 0) map.remove(end);
                    return false;
                }
            }
            return true;
        }
    }
}
