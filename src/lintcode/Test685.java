package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-10-8.
 * @description first-unique-number-in-stream
 */
public class Test685 {

    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if (null==nums || nums.length==0) {
            return -1;
        }
        // Deque<Integer> deque = new LinkedList<>();
        List<Integer> deque = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            if (set.contains(i)) {
                deque.remove(Integer.valueOf(i));
            } else {
                set.add(i);
                deque.add(i);
            }
            if (i==number) {
                return deque.get(0);
            }
        }
        return -1;
    }
}
