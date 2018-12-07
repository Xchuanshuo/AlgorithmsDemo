package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-12-5.
 * @description count-of-smaller-numbers-after-self
 */
public class Test1297 {

    public List<Integer> countSmaller(int[] nums) {
        // write your code here
        if (nums == null) return null;
        int n = nums.length;
        Integer[] result = new Integer[n];
        List<Integer> list = new ArrayList<>();
        for (int i=n-1;i>=0;i--) {
            result[i] = helper(list, nums[i]);
        }
        return Arrays.asList(result);
    }

    private int helper(List<Integer> list, int num) {
        int lo=0, high=list.size()-1;
        while (lo <= high) {
            int mid = lo + (high-lo)/2;
            if (list.get(mid) >= num) {
                high = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        list.add(lo, num);
        return lo;
    }
}
