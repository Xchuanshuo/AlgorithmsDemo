package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-12-7.
 * @description
 */
public class Test196 {

    public int findMissing(int[] nums) {
        // write your code here
        int n = nums.length;
        int totalSum = n*(n+1)/2;
        int localSum = Arrays.stream(nums).sum();
        return totalSum - localSum;
    }
}
