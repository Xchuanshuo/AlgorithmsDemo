package leetcode;

/**
 * @author Legend
 * @data by on 21-6-24.
 * @description https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 * idea:
 *      https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/solution/dong-tai-gui-hua-qian-zhui-he-by-zhu-leg-a2oj/
 */
public class Test1031 {

    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + nums[i];
        if (f > s) {
            int t = f; f = s; s = t;
        }
        int[][] dp = new int[n+1][2];
        int max = 0;
        for (int i = f;i <= n;i++) {
            int s1 = sum[i] - sum[i-f];
            dp[i][0] = Math.max(dp[i-1][0], s1);
            max = Math.max(max, s1 + dp[i-f][1]);
            if (i >= s) {
                int s2 = sum[i] - sum[i-s];
                dp[i][1] = Math.max(dp[i-1][1], s2);
                max = Math.max(max, s2 + dp[i-s][0]);
            }
        }
        return max;
    }
}
