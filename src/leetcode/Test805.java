package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-7-23.
 * @description https://leetcode-cn.com/problems/split-array-with-same-average/
 * idea:
 *      背包问题 能否均值分割 -> 能否 凑满和为j的背包 使得 j/k = total/n
 *      对于和j 可能有多个k, 用状态压缩, k在第几位表示使用k个数字凑成和j
 *      只需满足 j*n%total = 0, 且k能从 j-nums[i]的和转移过来
 */
public class Test805 {

    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        int total = Arrays.stream(nums).sum();
        int[] dp = new int[total/2 + 1];
        dp[0] = 1;
        for (int i = 0;i < n;i++) {
            for (int j = total/2;j >= nums[i] && j > 0;j--) {
                dp[j] |= dp[j-nums[i]] << 1;
                if (j*n % total == 0 && ((1<< (j*n/total)) & dp[j]) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};
        Test805 test = new Test805();
        boolean res = test.splitArraySameAverage(nums);
        System.out.println(res);
    }
}
