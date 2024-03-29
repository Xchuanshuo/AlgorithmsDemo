package leetcode;

/**
 * @author Legend
 * @data by on 21-5-12.
 * @description https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class Test718 {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
