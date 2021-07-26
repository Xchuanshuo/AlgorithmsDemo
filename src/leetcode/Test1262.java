package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-19.
 * @description https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 * idea:
 *      dp[i][j]表示位置i,对3取余为j的最大序列和, 这里j的取值为[0,1,2]
 *      对于当前数cur,若cur%3==0,对于dp[i][0] 则可以从位置i-1
 *      余数为0的状态转移过来 即dp[i-1][0] + cur, 对于dp[i][1], dp[i][2]
 *      同样也直接从 dp[i-1][1]、dp[i-1][2]转移过来
 *      状态转移方程: dp[i][0] = max(dp[i-1][0], dp[i-1][0]+cur)
 *                  dp[i][1] = max(dp[i-1][1], dp[i-1][1]+cur)
 *                  dp[i][2] = max(dp[i-1][2], dp[i-1][2]+cur)
 *     对于cur%3==1, dp[i][0] = max(dp[i-1][0], dp[i-1][2]+cur)
 *                  dp[i][1] = max(dp[i-1][1], dp[i-1][0]+cur)
 *                  dp[i][2] = max(dp[i-1][2], dp[i-1][1]+cur)
 *        cur%3==2,同理, 对于初始条件 dp[0][0]=0
 *      结果: dp[n-1][0] 即达到位置n-1,余数为0的最大序列和
 */
public class Test1262 {

    public int maxSumDivThree(int[] nums) {
        int n = nums.length, NINF = (int)-1e9;
        int[][] dp = new int[n][3];
        for (int[] d : dp) Arrays.fill(d, NINF);
        dp[0][0] = 0;
        dp[0][nums[0]%3] = nums[0];
        for (int i = 1;i < n;i++) {
            if (nums[i]%3 == 0) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0] + nums[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][1] + nums[i]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][2] + nums[i]);
            } else if (nums[i]%3 == 1) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] + nums[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + nums[i]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + nums[i]);
            } else if (nums[i]%3 == 2) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + nums[i]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] + nums[i]);
            }
        }
        return dp[n-1][0];
    }
}
