package lintcode;

import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-10-7.
 * @description majority-element-ii
 */
public class Test47 {

    public int majorityNumber(List<Integer> nums) {
        // write your code here
        Collections.sort(nums);
        int num = nums.get(0), count = 1;
        for (int i=1;i<nums.size();i++) {
            if (nums.get(i) == num) {
                count++;
            } else {
                if (count > nums.size()/3) {
                    return num;
                }
                num = nums.get(i);
                count = 1;
            }
        }
        return num;
    }
}
