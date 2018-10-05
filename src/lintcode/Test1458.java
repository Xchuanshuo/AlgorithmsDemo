package lintcode;

/**
 * @author Legend
 * @data by on 18-10-5.
 * @description minimum-submatrix
 */
public class Test1458 {

    public long minimumSubmatrix(int[][] arr) {
        // Write your code here
        int m = arr.length, n = arr[0].length;
        long result = arr[0][0];
        for (int i=0;i<m;i++) {
            long[] cur = new long[n+1];
            for (int j=i;j<m;j++) {
                for (int k=0;k<n;k++) {
                    cur[k] += arr[j][k];
                }
                result = Math.min(help(cur), result);
            }
        }
        return result;
    }

    private long help(long[] a) {
        long min = Long.MAX_VALUE, cur = 0;
        for (int i=0;i<a.length-1;i++) {
            cur = cur<0?cur+a[i]:a[i];
            min = Math.min(min, cur);
        }
        return min;
    }
}
