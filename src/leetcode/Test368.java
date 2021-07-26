package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/largest-divisible-subset/
 * idea:
 *      dp[i]表示以i位置数字结尾的最长子序列, c%b=0, b%a=0,  则 c%a=0;
 *      类似于求最大上升子序列 先将数组排序 这里条件是nums[i]%nums[j] == 0
 *      并且需要保存具体的序列
 */
public class Test368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] dp = new List[n];
        int max = 1;
        for (int i = 0;i <  nums.length;i++) {
            dp[i] = new LinkedList<>();
            dp[i].add(nums[i]);
            List<Integer> t;
            for (int j = i - 1;j >= 0;j--) {
                if (nums[i]%nums[j] == 0) {
                    t = new LinkedList<>(dp[j]);
                    t.add(nums[i]);
                    if (dp[i].size() < t.size()) {
                        dp[i] = t;
                        max = Math.max(max, dp[i].size());
                    }
                }
            }
        }
        for (int i = 0;i < n;i++) {
            if (dp[i].size() == max) return dp[i];
        }
        return new ArrayList<>();
    }
}
