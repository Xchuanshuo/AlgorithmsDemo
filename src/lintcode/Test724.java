package lintcode;

/**
 * @author Legend
 * @data by on 18-9-4.
 * @description minimum-partition
 * idea:
 *      dp 实质是个背包问题 这里是求数组切分成两部分后和的绝对值差值最小
 *      显然 当切分的两部分和相等时 最小值为0 所以这里可以先计算出全部的sum
 *      然后从sum/2位置开始查找 看是否存在某些数的和刚好为sum/2， 如果不存在
 *      就将sum-1 继续看是否存在 所以这里用dp[j]表示当元素总和为j时 能取到的最大
 *      元素和为多少（也就是背包问题中 背包最多能装满多少）最后得出来的dp[sum/2]即是
 *      一边最大的和 直接用sum-2*dp[sum/2] 即得出最终所求的结果
 */
public class Test724 {

    public int findMin(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0) return 0;
        int sum = 0;
        for (int i: nums) sum += i;
        int[] dp = new int[sum/2+1];
        for (int i=0;i<nums.length;i++) {
            for (int j=sum/2;j>=nums[i];j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        return sum - 2*dp[sum/2];
    }
}
