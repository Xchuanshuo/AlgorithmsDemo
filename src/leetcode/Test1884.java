package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-6-10.
 * @description https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors/
 * idea:
 *      dp[i][j]表示i层楼, j个鸡蛋需要的最少次数，对于前i层楼, 枚举扔鸡蛋的楼层j
 *      对于楼层j有两种情况 1.鸡蛋碎了,看前j-1层 使用1个鸡蛋的测试次数
 *                       2.鸡蛋没碎, 看j层以上得到楼层 即后i-j层楼 使用两个鸡蛋的测试次数
 *      两种情况取较大值,表示最坏情况下的测试次数
 *          即 dp[i][2]=max(dp[j-1][1],dp[i-j][2]) + 1, +1表示本次测试,
 *      初始值: dp[i][1]=i, 即前i层楼要保证测出目标楼层最坏情况下需要的次数为i次
 *      结果: d[n][2] 即n层楼2个鸡蛋能确定目标楼层需要的最小测试次数
 */
public class Test1884 {

    public int twoEggDrop(int n) {
        int[][] dp = new int[n+1][3];
        for (int[] d : dp) Arrays.fill(d, (int)1e9);
        for (int i = 0;i <= n;i++) dp[i][1] = i;
        dp[0][2] = dp[0][0] = 0;
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= i;j++) {
                dp[i][2] = Math.min(dp[i][2], Math.max(dp[j-1][1], dp[i-j][2])+1);
            }
        }
        return dp[n][2];
    }
}
