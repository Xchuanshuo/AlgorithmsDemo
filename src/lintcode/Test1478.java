package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description close-target-value
 */
public class Test1478 {

    public int closestTargetValue(int target, int[] array) {
        // Write your code here
        Arrays.sort(array);
        int left=0, right=array.length-1, result = Integer.MIN_VALUE;
        while (left < right) {
            if (array[left] + array[right]<=target) {
                result = Math.max(result, array[left] + array[right]);
            }
            if (array[left]+array[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result==Integer.MIN_VALUE?-1:result;
    }
}
