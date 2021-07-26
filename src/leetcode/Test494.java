package leetcode;

/**
 * @author Legend
 * @data by on 21-6-7.
 * @description https://leetcode-cn.com/problems/target-sum/
 * idea:
 *       left: 正子集, right: 负子集 S: 目标和: S
 *       left + right = sum  left - right = S
 *       left - (sum - left) = S  => left = (S + sum) / 2
 *
 *       统计和为left的正子集的方案数 即是目标和为S的方案数
 */
public class Test494 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((S+sum)%2 == 1) return 0;
        int target = (S + sum)/2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0;i < nums.length;i++) {
            for (int j = target;j >= nums[i];j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
