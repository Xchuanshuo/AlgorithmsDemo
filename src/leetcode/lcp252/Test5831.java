package leetcode.lcp252;

import java.util.Arrays;
/**
 * @author Legend
 * @data by on 21-8-1.
 * @description
 */
public class Test5831 {

    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = 0;
        for (int m : milestones) {
            sum += m;
            max = Math.max(max, m);
        }
        long s = sum - max;
        if (max <= s) return sum;
        return 2*s + 1;
    }
}
