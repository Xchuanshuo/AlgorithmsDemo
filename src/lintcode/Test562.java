package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-iv
 * idea:
 *      背包问题 dp[j]表示背包大小为j时有多少能装满的情况 那么在这里何为装满呢？
 *      就是指某个物品的大小加上一个已经装满物品的背包的大小等于当前装满的背包的大小
 *      而有多种情况下装满的背包 加上一个物品等于当前的背包 这样也就的得出了状态转移方程
 *      所以最终dp[j]+=dp[j-nums[i]] 然后注意初始条件dp[0]=1 也就是不装任何东西的情况下
 *      大小为0的背包刚好能装满...
 */
public class Test562 {

    public int backPackIV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=0;i<nums.length;i++) {
            for (int j=nums[i];j<=target;j++) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
