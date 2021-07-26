package leetcode;

/**
 * @author Legend
 * @data by on 21-5-18.
 * @description https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class Test1442 {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int res = 0;
        for (int len = 1;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = arr[i];
                } else {
                    dp[i][j] = dp[i][j-1]^arr[j];
                }
                if (dp[i][j] == 0) res += j - i;
            }
        }
        return res;
    }
}
