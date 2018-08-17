package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description longest-continuous-increasing-subsequence
 * idea:
 *      直接前后遍历即可 只需要O(1)的空间复杂度
 */
public class Test397 {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A==null || A.length==0) return 0;
        int result = 1, count = 1;
        for (int i=1;i<A.length;i++) {
            while (i<A.length && A[i]>A[i-1]) {
                i++;
                count++;
            }
            result = Math.max(result, count);
            count = 1;
        }
        for (int i=1;i<A.length;i++) {
            while (i<A.length && A[i]<A[i-1]) {
                i++;
                count++;
            }
            result = Math.max(result, count);
            count = 1;
        }
        return result;
    }
}
