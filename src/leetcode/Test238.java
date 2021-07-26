package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-21.
 * @description https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class Test238 {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int f = 1;
        for (int i = 1;i < n;i++) {
            f *= nums[i-1];
            res[i] = f;
        }
        f = 1;
        for (int i = n - 2;i >= 0;i--) {
            f *= nums[i+1];
            res[i] *= f;
        }
        return res;
    }
}
