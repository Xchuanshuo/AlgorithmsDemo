package lintcode;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description longest-increasing-subsequence
 * idea:
 *      dp[i]表示 位置i的最大增长子序列长度
 */
public class Test76 {

    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0) return 0;
        int[] dp = new int[nums.length+1];
        int max = 0;
        for (int i=0;i<nums.length;i++) {
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
