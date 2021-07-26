package leetcode;

/**
 * @author Legend
 * @data by on 21-6-25.
 * @description https://leetcode-cn.com/problems/rotate-function/
 */
public class Test396 {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        int f = 0;
        for (int i = 0;i < n;i++) {
            sum[i+1] = sum[i] + nums[i];
            f += i * nums[i];
        }
        int[] dp = new int[n]; dp[0] = f;
        int max = dp[0];
        for (int i = 1;i < n;i++) {
            int idx = n - i;
            dp[i] = dp[i-1] - (n-1)*(nums[idx]) + sum[idx] +(sum[n] - sum[idx+1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 化简 优化空间
    public int maxRotateFunction1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0;i < n;i++) {
            sum = sum + nums[i];
            f += i * nums[i];
        }
        int tmp =  f, max = f;
        for (int i = 1;i < n;i++) {
            int idx = n - i;
            tmp = tmp + sum - n*nums[idx];
            max = Math.max(max, tmp);
        }
        return max;
    }
}
