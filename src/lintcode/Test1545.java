package lintcode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Legend
 * @data by on 19-4-19.
 * @description last-closest-time
 */
public class Test1545 {

    public String lastTime(String time) {
        // Write your code here
        if (time == null || time.length()==0 || time.length()!=5) return "-1";
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        if (hour >= 24 || minute >59) return "-1";
        if (hour == 0 && minute == 0) {
            hour = 24;
        }
        int total = hour * 60 + minute - 1;
        return String.format("%02d:%02d", total/60, total%60);
    }
}
