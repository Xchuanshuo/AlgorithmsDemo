package lintcode;

/**
 * @author Legend
 * @data by on 18-9-7.
 * @description partition-equal-subset-sum
 * idea:
 *      dp 这道题可以转换为背包问题 这里是求数组刚好能被切分成和相等两部分 于是我们可以先求出
 *      所有元素的sum 如果和为奇数 显然是不可能切分成两部分和相等的整数 如果为偶数的话 把sum/2
 *      此时把sum/2当作一个背包大大小 然后不重复取数组里面的元素看能否刚好填满这个sum/2这个背包
 *      能填满的话 就说明能切分成和相等的两部分 这里只要背包能填满 结果就正确 所以可以得到状态转移方程为
 *             dp[j]=dp[j]||dp[j-nums[i]]
 */
public class Test588 {

    public boolean canPartition(int[] nums) {
        // write your code here
        int sum = 0;
        for (int i: nums) sum += i;
        if (sum%2 == 1) return false;
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        for (int i=0;i<nums.length;i++) {
            for (int j=sum/2;j>=nums[i];j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum/2];
    }
}
