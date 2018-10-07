package lintcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-7.
 * @description majority-number-iii
 */
public class Test48 {

    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        if (nums == null || nums.size() == 0) return -1;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i=0;i < nums.size();i++) {
            int current = nums.get(i);
            if (maps.containsKey(current)) {
                maps.put(current, maps.get(current)+1);
                if (maps.get(current) > nums.size()/k) return current;
            } else {
                maps.put(current, 1);
            }
        }
        return -1;
    }
}
