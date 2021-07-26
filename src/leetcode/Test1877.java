package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-7-20.
 * @description https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
 */
public class Test1877 {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j =  nums.length - 1;
        while (i < j) {
            res = Math.max(res, nums[i] + nums[j]);
            i++; j--;
        }
        return res;
    }
}
