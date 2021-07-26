package leetcode;

/**
 * @author Legend
 * @data by on 21-5-5.
 * @description https://leetcode-cn.com/problems/delete-and-earn/
 * idea:
 *      dp 转换成打家劫舍问题
 */
public class Test740 {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int n : nums) max = Math.max(max, n);
        int[] arr = new int[max + 1];
        for (int n : nums) arr[n]++;
        int[] dp = new int[arr.length];
        dp[1] = arr[1];
        for (int i = 2;i < arr.length;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + i * arr[i]);
        }
        return dp[arr.length - 1];
    }
}
