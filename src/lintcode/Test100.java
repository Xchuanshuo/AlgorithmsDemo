package lintcode;

/**
 * @author Legend
 * @data by on 18-9-14.
 * @description remove-duplicates-from-sorted-array
 */
public class Test100 {

    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i=1;i < nums.length;i++) {
            if (nums[i] != nums[i-1]) {

                nums[index++] = nums[i];
            }
        }
        return index;

    }
}
