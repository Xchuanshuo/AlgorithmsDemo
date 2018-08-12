package lintcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-16.
 * @description
 */
public class Test402 {

    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        int lo=0, sum=0, max=Integer.MIN_VALUE;
        int[] result = new int[2];
        for (int i=0;i < A.length;i++) {
            sum += A[i];
            if (max<sum) {
                max = sum;
                result[0] = lo;
                result[1] = i;
            }
            if (sum < 0) {
                sum = 0;
                lo = i+1;
            }
        }
        return Arrays.asList(result[0], result[1]);
    }

    public static void main(String[] args) {
        Test402 test = new Test402();
        int[] ints = {-3, 1, 3, -3, 4};
        System.out.println(test.continuousSubarraySum(ints));
    }
}
