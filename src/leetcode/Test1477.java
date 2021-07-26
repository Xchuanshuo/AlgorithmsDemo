package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Legend
 * @data by on 21-4-21.
 * @description https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 * idea:
 *      dp[i]表示前i个数字 最小的目标和为target长度为多少
 *      当找到新的target时, 从左边界找到最小的长度与其相加即可 每次取较小的值
 */
public class Test1477 {

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, preSum = 0;
        int min = 100000007;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, min);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1;i <= n;i++) {
            preSum += arr[i - 1];
            int d = preSum - target;
            dp[i] = dp[i-1];
            if (map.containsKey(d)) {
                int pos = map.get(d);
                int cur = i - pos;
                dp[i] = Math.min(dp[i], cur);
                min =  Math.min(min, dp[pos] + cur);
            }
            map.put(preSum, i);
        }
        return min ==100000007 ? -1 : min;
    }
}
