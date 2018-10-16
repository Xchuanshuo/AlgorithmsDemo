package lintcode;

/**
 * @author Legend
 * @data by on 18-10-17.
 * @description maximum-subarray-iv
 * idea:
 *      先求出数组的前缀和 然后计算前i-k(i>k)前缀和最小的值 用当前位置i的前缀和
 *      减去最小值 即得出最大子序列的和
 */
public class Test620 {

    public int maxSubarray4(int[] nums, int k) {
        // write your code here
        int n = nums.length;
        if (n < k) return 0;
        int[] preSum = new int[n+1];
        int preMin = 0, result = Integer.MIN_VALUE;
        for (int i=1;i<=nums.length;i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            if (i>k) preMin = Math.min(preMin, preSum[i-k]);
            if (i>=k) result = Math.max(result, preSum[i]-preMin);
        }
        return result;
    }
}
