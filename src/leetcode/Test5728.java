package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-12.
 * @description https://leetcode-cn.com/problems/minimum-sideway-jumps/
 * idea:
 *      dp[i][j]表示在第i个点在跑道j的最小侧跳次数
 *      初始条件: 从中间跑道开始 中间跑道为0 两边侧跳为1 即dp[0][1] = 0, dp[0][0]=dp[0][2]=1
 *      状态: 对于点i跑道j, 如果从点i-1的跑道j直接过来，则不需要侧跳，其它情况则需要1次
 *      边界: 当前位置如果有障碍物，则不能跳到此处, 点i-1也不能通直接到当前位置后侧跳到其它跑道
 */
public class Test5728 {

    public int minSideJumps(int[] b) {
        int n = b.length - 1;
        int[][] dp = new int[n+1][3];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE- 10);
        dp[0][1] = 0;
        dp[0][0] = dp[0][2] = 1;
        for (int i = 1;i  <= n;i++) {
            for (int j = 0;j < 3;j++) {
                if (b[i] == j + 1) continue;
                for (int k = 0;k < 3;k++) {
                    int cost = 0;
                    if (b[i] == k + 1) continue;
                    if (j != k) cost = 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + cost);
                }
            }
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
