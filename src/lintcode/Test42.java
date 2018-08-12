package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-16.
 * @description
 */
public class Test42 {

    public int maxTwoSubArrays(List<Integer> nums) {
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i=0;i < nums.size();i++) {
            if (currentSum <= 0) {
                currentSum = nums.get(i);
            } else {
                currentSum += nums.get(i);
            }
            left[i] = maxSum = Math.max(currentSum, maxSum);
        }
        currentSum = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i=nums.size()-1;i >= 0;i--) {
            if (currentSum <= 0) {
                currentSum = nums.get(i);
            } else {
                currentSum += nums.get(i);
            }
            right[i] = maxSum = Math.max(currentSum, maxSum);
        }
        maxSum = Integer.MIN_VALUE;
        for (int i=0;i < nums.size()-1;i++) {
            maxSum = Math.max(maxSum, left[i]+right[i+1]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Test42 test = new Test42();
        List<Integer> list = Arrays.asList(1, 3, -1, 2, -1, 2);
        System.out.println(test.maxTwoSubArrays(list));
    }
}
