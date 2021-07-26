package leetcode;

/**
 * @author Legend
 * @data by on 21-5-12.
 * @description https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */
public class Test1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n+1];
        for (int i = 0;i < n;i++) {
            prefix[i+1] = prefix[i]^arr[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0;i < queries.length;i++) {
            int[] q = queries[i];
            res[i] = prefix[q[1]+1]^prefix[q[0]];
        }
        return res;
    }
}
