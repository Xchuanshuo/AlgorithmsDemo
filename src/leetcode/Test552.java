package leetcode;

/**
 * @author Legend
 * @data by on 21-6-23.
 * @description https://leetcode-cn.com/problems/student-attendance-record-ii/
 * idea:
 *      dp[i][j][k] 表示前i个元素包括j个'A'，且结尾为连续k个'L'的排列方案数
 *      分别列举所有情况, 要求不对于一个'A' 以及不超过两个连续的L
 *      对于满足要求的排列，划分为6类
 *      1.dp[i][0][0] 0A0L  可由 1+'P', 2+'P', 3+'P'
 *      2.dp[i][0][1] 0A1L  可由 1+'L'
 *      3.dp[i][0][2] 0A2L  可由 2+'L'
 *      4.dp[i][1][0] 1A0L  可由 1+'A', 2+'A', 3+'A', 4+'P', 5+'P', 6+'P'
 *      5.dp[i][1][1] 1A1L  可由 4+'L'
 *      6.dp[i][1][2] 1A2L  可由 5+'L'
 *
 *      最后累加6类排列的方案数 优化: 当前状态只依赖上一轮状态, 只需要O(1)的空间
 */
public class Test552 {

    public int checkRecord(int n) {
        int M =  (int)1e9 + 7;
        long[][][] dp = new long[n][2][3];
        dp[0][0][0] = dp[0][0][1] = dp[0][1][0] = 1;
        for (int i = 1;i < n;i++) {
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2])%M;
            dp[i][0][1] = dp[i-1][0][0];
            dp[i][0][2] = dp[i-1][0][1];
            dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]
                    + dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2])%M;
            dp[i][1][1] = dp[i-1][1][0];
            dp[i][1][2] = dp[i-1][1][1];
        }
        long res = 0;
        for (int i = 0;i <= 1;i++) {
            for (int j = 0;j <= 2;j++) {
                res = (res + dp[n-1][i][j])%M;
            }
        }
        return (int)res;
    }

    public int checkRecord1(int n) {
        int M =  (int)1e9 + 7;
        long dp1, dp2, dp3 = 0, dp4, dp5 = 0, dp6 = 0;
        dp1 = dp2 = dp4 = 1;
        for (int i = 1;i < n;i++) {
            long t2 = (dp1 + dp2 + dp3 + dp4 + dp5 + dp6)%M;
            long t1 = (dp1 + dp2 + dp3)%M;
            dp3 = dp2;
            dp2 = dp1;
            dp6 = dp5;
            dp5 = dp4;
            dp1 = t1;
            dp4 = t2;
        }
        long res = (dp1 + dp2 + dp3 + dp4 + dp5 + dp6)%M;
        return (int)res;
    }
}
