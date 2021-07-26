package leetcode;

/**
 * @author Legend
 * @data by on 21-5-15.
 * @description https://leetcode-cn.com/problems/soup-servings/
 * idea:
 *      4个操作每个调整都是25的倍数, 所以可以直接N/25,
 *      再将4个操作分别变为 (-4,-0) (-3,-1) (-2,-2) (-1,-3)
 *      定义dp[i][j]为A剩余i,B剩余j时的概率为多少, 对于剩余量i,j有上述4个操作
 *      所以状态转移方程为
 *      dp[i][j]=0.25*(dp[i-4][j] + dp[i-3][j-1] + dp[i-2][j-2] + dp[i-1][j-3])
 *      初始条件 dp[0][0] A,B都为0时的概率为 0.25*(0.5 + 0.5 + 0.5 + 0.5)=0.5
 *              dp[0][1..n]=1, dp[1..n][0]=0
 *      结果 dp[n][n]
 */
public class Test808 {

    public double soupServings(int N) {
        if (N >= 5000) return 1.0;
        int n = (int) Math.ceil(N/25.0);
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = 0.5;
        for (int i = 1;i <= n;i++) {
            dp[0][i] = 1.0;
            dp[i][0] = 0.0;
        }
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= n;j++) {
                dp[i][j] = 0.25*(dp[max(i-4)][j] + dp[max(i-3)][max(j-1)]
                        + dp[max(i-2)][max(j-2)] + dp[max(i-1)][max(j-3)]);
            }
        }
        return dp[n][n];
    }

    private int max(int v) {
        return Math.max(v, 0);
    }
}
