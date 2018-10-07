package lintcode;

import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-10-1.
 * @description recover-rotated-sorted-array
 * idea:
 *      与rotate-string一样
 */
public class Test39 {

    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int pos = 0;
        for (int i=1;i<nums.size();i++) {
            if (nums.get(i) < nums.get(i-1)) {
                pos = i;
                break;
            }
        }
        for (int i=0;i<pos/2;i++) {
            swap(nums, i, pos-i-1);
        }
        for (int i=pos,j=nums.size()-1;i<(nums.size()-pos)/2+pos;i++,j--) {
            swap(nums ,i ,j);
        }
        Collections.reverse(nums);
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
