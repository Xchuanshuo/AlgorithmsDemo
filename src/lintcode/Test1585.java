package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-9-1.
 * @description moving-stone
 */
public class Test1585 {

    public int movingStones(int[] arr) {
        // Write your code here
        int res1=0, res2=0, n=arr.length;
        Arrays.sort(arr);
        for (int i=0;i<n;i++) {
            res1 += Math.abs(arr[i]-i*2-1);
            res2 += Math.abs(arr[i]-i*2-2);
        }
        return Math.min(res1, res2);
    }
}
