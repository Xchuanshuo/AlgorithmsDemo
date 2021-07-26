package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/largest-perimeter-triangle/submissions/
 */
public class Test976 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1;i >= 2;i--) {
            if (nums[i-2] + nums[i-1] > nums[i]) {
                return nums[i-2] + nums[i-1] + nums[i];
            }
        }
        return 0;
    }
}
