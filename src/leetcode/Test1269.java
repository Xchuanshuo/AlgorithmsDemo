package leetcode;

/**
 * @author Legend
 * @data by on 21-5-13.
 * @description https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 * idea:
 *      用dp[i][j]表示第i个位置,走j步还在原地的方案数量
 *      第i个位置走j步还在原地 走j步肯定是从j-1步转移过来有3种情况
 *      1.第j-1步在第i-1的位置 则 dp[i][j] += dp[i-1[j-1]
 *      2.第j-1步就在i位置 则 dp[i][j] += dp[i][j-1]
 *      3.第j-1步在i+1的位置 则 dp[i][j] += dp[i+1][j-1]
 *      结果: dp[1][steps] 即在第1个位置走了steps步还在原地的方案数
 *      初始: dp[1][0] = 1 表示第1个位置走0步的方案数为1
 *
 *      优化: 1.arrLen > steps 的位置是不能走到的, 可以直接过滤掉 减少时空复杂度
 *           2.滚动数组 每一步j的状态只依赖于上一步 所以可以尝试直接变成一维, 但计算
 *             状态时 dp[i]需要依赖dp[i-1], 而i-1必须是来自上一层 只用一维 计算i时
 *             i-1已经在本层计算过了 所以状态转移不正确 用两维长度为2的空间即可 每次对2取模
 */
public class Test1269 {

    public int numWays1(int steps, int arrLen) {
        int[][] dp = new int[steps+1][steps+1];
        int M = (int)1e9 + 7;
        dp[1][0] = 1;
        for (int j = 1;j <= steps;j++) {
            int min = Math.min(steps, arrLen);
            for (int i = 1;i <= min;i++) {
                dp[i][j] = dp[i][j-1];
                dp[i][j] = (dp[i][j] + dp[i-1][j-1])%M;
                if (i+1<=min) dp[i][j] = (dp[i][j] + dp[i+1][j-1])%M;
            }
        }
        return dp[1][steps];
    }

    public int numWays2(int steps, int arrLen) {
        int[][] dp = new int[steps+1][2];
        int M = (int)1e9 + 7;
        dp[1][0]= 1;
        int min = Math.min(steps, arrLen);
        for (int j = 1;j <= steps;j++) {
            for (int i = 1;i <= min;i++) {
                dp[i][j%2] = dp[i][(j-1)%2];
                dp[i][j%2] = (dp[i][j%2] + dp[i-1][(j-1)%2])%M;
                if (i+1<=min) dp[i][j%2]= (dp[i][j%2] + dp[i+1][(j-1)%2])%M;
            }
        }
        return dp[1][steps%2];
    }
}
