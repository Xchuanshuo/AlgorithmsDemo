package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-v
 * idea:
 *      背包问题 与backpack-vi(Test562)一样 但这里是要求背包不能重复
 *      问题也与之前的ii(Test125)和iii(Test440)问题一样 从前向后遍历表示能重复，
 *      从后向前遍历意味着不能重复 dp[7]..dp[3] 从后向前遍历时没有依赖这一轮循环中其它的情况
 *      只依赖上一轮 而dp[3]..dp[7]实际是要考虑之前的情况 所以这样遍历到最后 都是没有重复的情况
 *      如果还是不能理解 就去拿小数据 画出两种情况的表格比较一下就可以了
 */
public class Test563 {

    public int backPackV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=0;i<nums.length;i++) {
            for (int j=target;j>=nums[i];j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
