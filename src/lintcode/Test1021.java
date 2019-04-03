package lintcode;

/**
 * @author Legend
 * @data by on 19-4-3.
 * @description number-of-subarrays-with-bounded-maximum
 */
public class Test1021 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // Write your code here
        int result = 0, count = 0, start = 0;
        for (int i = 0;i<A.length;i++) {
            if (A[i] >= L && A[i] <= R) {
                count = i - start + 1;
                result += count;
            } else if (A[i] < L) {
                result += count;
            } else {
                start = i + 1;
                count = 0;
            }
        }
        return result;
    }
}
