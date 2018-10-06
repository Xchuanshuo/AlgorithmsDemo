package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-10-6.
 * @description lasttime-norepeat
 */
public class Test1554 {

    public String lastTime(String time) {
        // Write your code here
        if (time.length()!=5 || time.charAt(2)!=':') return "-1";
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        if (h<0 || h>=24 || m<0 || m>=60) return "-1";
        int total = h*60 + m;
        while (total >= 0) {
            if (total == 0) total = 24*60;
            total -= 1;
            String result = String.format("%02d:%02d", total/60, total%60);
            Set<Character> set = new HashSet<>();
            for (char c: result.toCharArray()) {
                set.add(c);
            }
            if (set.size() == 5) {
                return result;
            }
        }
        return "-1";
    }
}
