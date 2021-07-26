package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/combination-sum-iv/
 * idea:
 *      排列: 任意顺序 前面的物品可以在后面出现 所以外层循环用背包大小
 *      组合: 不计重复数字的排列, 内层循环用背包, 后面的物品肯定不能在前面物品之前
 */
public class Test377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0 ;i <= target;i++) {
            for (int j = 0;j < nums.length;j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
