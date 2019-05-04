package lintcode;

/**
 * @author Legend
 * @data by on 19-5-3.
 * @description coins-in-a-line-iii
 * idea:
 *      dp 与coins-ii相比 这里变成了从左右两边取 ii是只需考虑前面的情况，区间变化是规律的 而本题每次区间变化不规律
 *      对应着不同的情况，所以应该枚举所有可能的区间来求选手能取得的最大值 区间型dp 用dp[i][j]表示在区间[i,j]里
 *      面能获得的最大值. 同样，要当前选手在区间[i,j]取得最大值，就要使前一个人尽量取得最小值 前一个人有两种取法,
 *      1.取左边硬币 此时能取到的值总和为dp[i+1][j] 2.取右边硬币 此时能取到的值总和为dp[i][j-1]
 *      当前选手只要用区间[i,j]总价值 - 前一个人能取得价值的最小值 可使自己获得最大价值, 于是可以得出状态
 *      转移方程 dp[i][j] = sum[i][j] - min(dp[i+1][j], dp[i][j-1])  注意初始条件dp[i][i]表示
 *      只剩下的硬币区间为[i,i]时能取得的最大值 也就是硬币i本身的价值 即dp[i][i] = values[i];
 *      最后与coins-ii一样 只需要比较dp[0][n-1] 是否超过总价值数的一半 即可得出结果\
 *          .......博弈论类型的动态规划真的是绕的很.......
 */
public class Test396 {

    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int[] sum = new int[n+1];
        for (int i = 1;i <= n;i++) {
            sum[i] = sum[i-1] + values[i-1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i++) {
            dp[i][i] = values[i];
        }
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i < n;i++) {
                int j = i + len - 1;
                if (j >= n) continue;
                int s = sum[j+1] - sum[i];
                dp[i][j] = s - Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1] > sum[n]/2;
    }
}
