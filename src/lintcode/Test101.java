package lintcode;

/**
 * @author Legend
 * @data by on 18-9-14.
 * @description remove-duplicates-from-sorted-array-ii
 */
public class Test101 {

    public int removeDuplicates(int[] nums) {
        // write your code here
        int index = 0;
        for (int num: nums) {
            if (index<2 || num!=nums[index-2]) {
                nums[index++] = num;
            }
        }
        return index;
    }
}
