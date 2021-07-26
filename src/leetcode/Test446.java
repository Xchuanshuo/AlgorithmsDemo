package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-4-25.
 * @description https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/
 * idea:
 *      dp[i]表示以位置i元素结尾的等差子序列数量
 */
public class Test446 {

    // dp[i]表示以位置i元素结尾的等差子序列数量
    public int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0;i < n;i++) dp[i] = new HashMap<>();
        int res = 0;
        for (int i = 1;i < n;i++) {
            for (int j = 0;j < i;j++) {
                long diff = (long)nums[i] - (long)nums[j];
                if(diff > Integer.MAX_VALUE) continue;
                if(diff <Integer.MIN_VALUE) continue;
                int d = (int)diff;
                Map<Integer, Integer> map = dp[j];
                if (!map.containsKey(d)) {
                    dp[i].put(d, dp[i].getOrDefault(d, 0) + 1);
                } else {
                    dp[i].put(d, dp[i].getOrDefault(d, 0) +  map.get(d) + 1);
                }
                res += map.getOrDefault(d, 0);
            }
        }
        return res;
    }

    // dp[i][j]表示以位置i,j的数组成结尾的等差数列的个数
    // dp[i][j]=dp[j][idx] + 1
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0;i < n;i++) {
            long key = (long)nums[i];
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(i);
        }
        int res = 0;
        for (int i = 1;i < n;i++) {
            for (int j = i - 1;j >= 0;j--) {
                long d = (long)nums[i] - (long)nums[j];
                long target = (long)nums[j] - d;
                List<Integer> list = map.get(target);
                if (list != null) {
                    for (int idx : list) {
                        if (idx >= j) continue;
                        dp[i][j] += dp[j][idx] + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
