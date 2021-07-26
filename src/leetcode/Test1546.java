package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-22.
 * @description https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class Test1546 {

    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[n+1];
        int sum = 0;
        map.put(0, 0);
        for (int i = 1;i <= n;i++) {
            sum += nums[i-1];
            dp[i] = dp[i-1];
            int d = sum - target;
            if (map.containsKey(d)) {
                dp[i] = Math.max(dp[i], dp[map.get(d)] + 1);
            }
            map.put(sum, i);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Test1546 test = new Test1546();
        int[] nums = {3,0};
        int res = test.maxNonOverlapping(nums, 3);
        System.out.println(res);
    }
}
