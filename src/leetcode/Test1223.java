package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-19.
 * @description https://leetcode-cn.com/problems/dice-roll-simulation/
 * idea:
 *      用dp[i][j]表示掷骰子i次, 以点j结尾时的不同点数序列数量
 *      因为对于点数j不能超过连续的rollMax[j-1]个, 所以当点数
 *      1.刚好超过最大连续个数时, 去除掉1次连续的情况, 即dp[i][j]--;
 *      2.当前掷骰子次数大于最大连续个数时, 需要去除全部以连续个数个序列
 *      结尾的方案数, 即dp[i-rollMax(j-1)-1][k]
 *      如以6结尾, 最大个数为3,
 *      当前掷骰子第4次, 只需要去除1种情况 6 6 6 6 也就是连续4个为6
 *      当前掷骰子第5次, 以连续3个6结尾的包括
 *       x 6 6 6 cur -> dp[1][x]  假设后面直接掷出3个6 方案数即
 *       掷骰子1次,点数为x的方案, 且x!=6 (x=6实际上在刚好超过时,已经去掉了)
 */
public class Test1223 {

    public int dieSimulator(int n, int[] rollMax) {
        int M = (int)1e9 + 7;
        int[][] dp = new int[n+1][7];
        for (int i = 1;i <= 6;i++) {
            dp[1][i] = 1;
        }
        for (int i = 2;i <= n;i++) {
            for (int j = 1;j <= 6;j++) {
                dp[i][j] = Arrays.stream(dp[i-1]).reduce(0, (a,b) -> (a+b)%M);
                if (i == rollMax[j-1]+1) dp[i][j]--;
                else if (i  > rollMax[j-1]+1) {
                    for (int k = 1;k <= 6;k++) {
                        if (j == k) continue;
                        dp[i][j] = (dp[i][j] - dp[i-rollMax[j-1]-1][k] + M) % M;
                    }
                }
            }
        }
        return  Arrays.stream(dp[n]).reduce(0, (a,b) -> (a+b)%M);
    }
}
