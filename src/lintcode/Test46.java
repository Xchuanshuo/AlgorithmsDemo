package lintcode;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-7.
 * @description majority-element
 */
public class Test46 {

    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int res = 0;
        if (nums == null || nums.size() == 0) return -1;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i=0;i < nums.size();i++) {
            int current = nums.get(i);
            if (maps.containsKey(current)) {
                maps.put(current, maps.get(current)+1);
                if (maps.get(current) > nums.size()/2) res = current;
            } else {
                maps.put(current, 1);
            }
        }

        return res;
    }

    public int majorityNumber2(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return -1;
        int num = nums.get(0);
        int count = 0;
        for (int n: nums) {
            count += n==num?1:-1;
            if (count == 0) {
                num = n;
                count = 1;
            }
        }
        return num;
    }
}
