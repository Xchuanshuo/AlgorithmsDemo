package leetcode;

/**
 * @author Legend
 * @data by on 21-5-8.
 * @description https://leetcode-cn.com/problems/knight-dialer/
 * idea:
 *      dp[i][j]表示走i步以数字j结尾的方案数为多少
 *      状态转移方程: dp[i][j] += dp[i-1][src] 表示从走了i-1步 且前一步可以到达j的路径转移过来
 *      初始状态: dp[1][i] = 1 表示对于任意数字i,只走1步的情况下的方案数为1
 *      结果: 累计走了n步后所有不同数字结尾的方案数 即 sum(dp[n][0],dp[n][1]...,dp[n][9])
 */
public class Test935 {

    int M = (int)1e9 + 7;
    public int knightDialer(int n) {
        int[][] dp = new int[n+1][10];
        int[][] path = {{4, 6}, {6, 8}, {7, 9},{4, 8}, {3, 9, 0},{},{1,7,0}, {2,6},{1,3},{4,2}};
        for (int i = 0;i <= 9;i++) {
            dp[1][i] = 1;
        }
        for (int i = 1;i <= n;i++) {
            for (int src = 0;src <= 9;src++) {
                for (int j : path[src]) {
                    dp[i][j] = (dp[i][j] +  dp[i-1][src])%M;
                }
            }
        }
        long res = 0;
        for (int i = 0;i <= 9;i++) {
            res = (res + dp[n][i])%M;
        }
        return (int)res;
    }
}
