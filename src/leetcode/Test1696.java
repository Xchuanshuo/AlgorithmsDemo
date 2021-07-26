package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Legend
 * @data by on 21-7-18.
 * @description https://leetcode-cn.com/problems/jump-game-vi/
 * idea:
 *      单调栈求滑动窗口的最大值
 */
public class Test1696 {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0;i < n;i++) {
            dp[i] = nums[i];
            if (!dq.isEmpty()) {
                dp[i] = nums[i] + dp[dq.peekFirst()];
            }
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
        }
        return dp[n-1];
    }
}
