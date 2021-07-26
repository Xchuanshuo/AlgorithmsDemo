package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-7-15.
 * @description https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
 */
public class Test1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1;i < arr.length;i++) {
            if (arr[i] - arr[i-1] > 1) {
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
