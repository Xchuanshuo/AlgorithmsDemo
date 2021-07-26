package leetcode;

/**
 * @author Legend
 * @data by on 21-5-17.
 * @description https://leetcode-cn.com/problems/maximum-subarray-sum-with-one-deletion/
 */
public class Test1186 {

    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        int max = arr[0];
        for (int i = 1;i < n;i++) {
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
