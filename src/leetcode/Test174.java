package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-18.
 * @description https://leetcode-cn.com/problems/dungeon-game/
 * idea:
 *      要求最小血量 -> 到达终端时血量为1 用dp[i][j]表示从点i,j出发所需的最小血量
 *      从后往前遍历, 只需要看到达右边和下边哪个需要的血量更少, 然后减去当前消耗即可
 *      若减去的差值为负, 说明当前能补充的血量比走到下面或右边需要的最少血量更加多,
 *      所以对于当前位置 需要的最少血量只需要为1即可
 */
public class Test174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[m][n-1] = 1; dp[m-1][n] = 1;
        for (int i = m - 1;i >= 0;i--) {
            for (int j = n - 1;j >= 0;j--) {
                int hp = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = Math.max(hp, 1);
            }
        }
        return dp[0][0];
    }
}
