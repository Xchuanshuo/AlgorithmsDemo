package leetcode;

/**
 * @author Legend
 * @data by on 21-5-1.
 * @description https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/submissions/
 * idea:
 *      类似背包问题, dp[i][t]表示前i个骰子扔出目标和为t的方案数 当前点数为j时
 *      方案数为 dp[i-1][t-j] 累计当前所有不同点数 得出状态转移方程
 *      dp[i][t] += dp[i-1][t-j]
 *      最终结果: dp[d][target] 即使用d个骰子 目标和为Target时的方案数
 *
 *      滚动数组优化: 每一轮计算只依赖上一轮的状态 空间可以优化成O(target)
 *      (本题实际是求排列总数,意味着 2 1和 1 2算两个不同的结果, 所以骰子点数放在内层)
 */
public class Test1155 {

    int M = (int)1e9 + 7;
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1;i <= d;i++) {
            for (int j = f;j >= 1;j--) {
                for (int t = target;t >= j;t--) {
                    dp[i][t] = (dp[i][t] + dp[i-1][t-j] ) %M;
                }
            }
        }
        return dp[d][target];
    }


    public int numRollsToTarget1(int d, int f, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1;i <= d;i++) {
            for (int t = target;t >= 0;t--) {
                dp[t] = 0;
                for (int j = 1;j <= Math.min(f,t);j++) {
                    dp[t] = (dp[t] + dp[t-j] )%M;
                }
            }
        }
        return dp[target];
    }
}
