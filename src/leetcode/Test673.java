package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class Test673 {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 1;
        for (int i = 1;i < n;i++) {
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0;i < n;i++) {
            if (dp[i] == max) res += cnt[i];
        }
        return res;
    }
}
