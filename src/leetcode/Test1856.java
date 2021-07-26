package leetcode;

import java.util.Stack;

/**
 * @author Legend
 * @data by on 21-5-29.
 * @description https://leetcode-cn.com/problems/maximum-subarray-min-product/
 * idea:
 *      前缀和 + 单调递增栈 + 首尾哨兵
 */
public class Test1856 {

    public int maxSumMinProduct(int[] numS) {
        int n = numS.length + 2, M = (int)1e9 + 7;
        int[] nums = new int[n];
        for (int i = 1;i <= n - 2;i++) {
            nums[i] = numS[i-1];
        }
        long[] sums = new long[n+1];
        for (int i = 0;i < n;i++) sums[i+1] = sums[i] + nums[i];
        Stack<Integer> s = new Stack<>();
        long max = 0;
        for (int i = 0;i < n;i++) {
            while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
                int cur = nums[s.pop()];
                int t = s.peek();
                long sum = sums[i] - sums[t+1];
                max = Math.max(max, cur * sum);
            }
            s.push(i);
        }
        return (int)(max%M);
    }
}
