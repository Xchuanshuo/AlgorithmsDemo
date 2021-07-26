package leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Legend
 * @data by on 21-4-24.
 * @description https://leetcode-cn.com/problems/constrained-subsequence-sum/comments/
 * idea:
 *      dp + 单调队列优化 对于dp[i] 要求前k个元素的最大值 直接遍历前k个位置会超时
 *      维护一个单调递减队列
 */
public class Test1425 {

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1;i < n;i++) {
            dp[i] = nums[i];
            if (!dq.isEmpty()) {
                dp[i] = Math.max(nums[i], dp[dq.peekFirst()] + nums[i]);
            }
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
