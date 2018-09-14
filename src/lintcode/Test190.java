package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-9-14.
 * @description next-permutation-ii
 * idea:
 *      与Test52一样
 */
public class Test190 {

    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0) return;
        int n = nums.length;
        int pos = n-2;
        while (pos>=0 && nums[pos]>=nums[pos+1]) pos--;
        if (pos < 0) {
            Arrays.sort(nums);
            return;
        }
        int i = n-1;
        while (nums[i]<=nums[pos]) i--;
        swap(nums, i, pos);
        while (pos+1 < n) {
            swap(nums, ++pos, --n);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
