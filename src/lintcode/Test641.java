package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-7-3.
 * @description Missing Ranges
 */
public class Test641 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(generateStr(lower, upper));
            return result;
        }
        if (lower<nums[0]) {
            result.add(generateStr(lower, nums[0]-1));
        }
        for (int i=1;i<nums.length;i++) {
            if (nums[i] == nums[i-1]) continue;
            if (nums[i] != nums[i-1]+1) {
                result.add(generateStr(nums[i-1]+1, nums[i]-1));
            }
        }
        if (upper>nums[nums.length-1]) {
            result.add(generateStr(nums[nums.length-1]+1, upper));
        }
        return result;
    }

    private String generateStr(int a, int b) {
        if (a==b) {
            return a+"";
        }
        return a+"->"+b;
    }

}
