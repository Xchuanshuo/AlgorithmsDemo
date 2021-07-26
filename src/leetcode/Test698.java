package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-12.
 * @description https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
public class Test698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        if (sum%k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[n-1] > target) return false;
        int cnt = n - 1;
        while (cnt >= 0 && k > 0 && nums[cnt] == target) {
            cnt--; k--;
        }
        if (k == 0) return true;
        int[] group = new int[k];
        return dfs(group, nums, cnt, target);
    }

    private boolean dfs(int[] group, int[] nums,  int cur, int target) {
        if (cur < 0) return true;
        for (int i = 0;i < group.length;i++) {
            if (group[i] + nums[cur] <= target) {
                group[i] += nums[cur];
                if (dfs(group, nums, cur-1, target)) {
                    return true;
                }
                group[i] -= nums[cur];
            }
            if (group[i] == 0) break;
        }
        return false;
    }
}
