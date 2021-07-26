package leetcode;

/**
 * @author Legend
 * @data by on 21-7-17.
 * @description https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/
 * idea:
 *      dp[i][0] 以位置i元素结尾的乘积为负数的子数组长度
 *      dp[i][1] 以位置i元素结尾的乘积为正数的子数组长度
 *      对于当前元素分为两种情况,
 *      1.大于0, 此时 dp[i][1] = dp[i-1][1] + 1
 *                  dp[i][0] = dp[i-1][0] + 1 (dp[i-1][0]>0)
 *      2.小于0, 此时 dp[i][1] = dp[i-1][0] + 1 (dp[i-1][0]>0)
 *                  dp[i][0] = dp[i-1][1] + 1;
 *      结果: 对于所有dp[i][1] 取最大值
 */
public class Test1567 {

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0] > 0 ? 1 : 0;
        dp[0][0] = nums[0] < 0 ? 1 : 0;
        int res = dp[0][1];
        for (int i = 1;i < n;i++) {
            if (nums[i] > 0) {
                dp[i][1] = dp[i-1][1] + 1;
                if (dp[i-1][0] > 0) {
                    dp[i][0] = dp[i-1][0] + 1;
                }
            } else if (nums[i] < 0) {
                dp[i][0] = dp[i-1][1] + 1;
                if (dp[i-1][0] > 0) {
                    dp[i][1] = dp[i-1][0] + 1;
                }
            }
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
