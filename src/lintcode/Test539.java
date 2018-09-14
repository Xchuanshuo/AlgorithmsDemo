package lintcode;

/**
 * @author Legend
 * @data by on 18-9-14.
 * @description move-zeros
 */
public class Test539 {

    public void moveZeroes(int[] nums) {
        // write your code here
        int left =0,right = 0;
        while(right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }

    }
}
