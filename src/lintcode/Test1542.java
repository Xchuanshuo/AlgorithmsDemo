package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 19-4-20.
 * @description nexttime-norepeat
 */
public class Test1542 {

    public String nextTime(String time) {
        // Write your code here
        if (time == null || time.length()==0 || time.length()!=5) return "-1";
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        if (hour > 23 || minute >59) return "-1";
        Set<Character> set = new HashSet<>();
        int total = (hour * 60 + minute + 1)%(60*23+59);
        for (;;total++) {
            String str = String.format("%02d:%02d", total/60, total%60);
            set.clear();
            for (char c : str.toCharArray()) set.add(c);
            if (set.size() == 5) return str;
        }
    }
}
