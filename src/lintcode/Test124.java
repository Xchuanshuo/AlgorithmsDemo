package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-6-30.
 * @description longest-consecutive-sequence
 */
public class Test124 {

    public int longestConsecutive(int[] num) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for (int i: num) {
            set.add(i);
        }
        int result = Integer.MIN_VALUE;
        for (int cur: num) {
            if (set.contains(cur)) {
                set.remove(cur);
                int pre = cur-1;
                while (set.contains(pre)) {
                    set.remove(pre);
                    pre--;
                }
                int next = cur+1;
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                }
                result = Math.max(result, next-pre-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test124 test = new Test124();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(test.longestConsecutive(nums));
    }
}
