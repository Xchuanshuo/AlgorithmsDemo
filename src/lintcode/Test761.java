package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-12-7.
 * @description smallest-subset
 */
public class Test761 {

    public int minElements(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        long sum = Arrays.stream(arr)
                .reduce(0, ((left, right) -> left + right));
        int subSum = 0, i;
        for (i=arr.length-1;i>0;i--) {
            subSum += arr[i];
            if (subSum > sum - subSum) {
                break;
            }
        }
        return arr.length - i;
    }
}
