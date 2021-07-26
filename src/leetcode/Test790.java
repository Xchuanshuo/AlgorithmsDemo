package leetcode;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.Selector;

/**
 * @author Legend
 * @data by on 21-4-20.
 * @description https://leetcode-cn.com/problems/domino-and-tromino-tiling/
 * idea:
 *      dp[i][0]表示刚好填满时的方案数 dp[i][1]表示缺一个角时的方案数
 *      要求dp[i][0] 可以在前i-1后面加1块竖着的多米若, i-2后面放两块横着的多米若 可保证不会出现重复情况
 *         还需要考虑i-1缺少一个角时 添加一个托米若(L) 缺角可能包含上面和下面缺角两种情况 所以需要2*dp[i][1]
 *      要求dp[i][1] 考虑在i-2刚好填满时 添加一个托米若(L), 以及在i-1缺少一个角时 添加一个横着的多米若
 *      最终状态转移方程为:
 *      dp[i][0] = dp[i-1][0] + dp[i-2][0] + 2*dp[i-1][1]
 *      dp[i][1] = dp[i-2][0] + dp[i-1][1]
 *
 *      dp[n][0]为最终解
 */
public class Test790 {

    public int numTilings(int N) {
        long[][] dp = new long[N + 1][2];
        int M = 1000000007;
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2;i <= N;i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + 2 * dp[i-1][1])%M;
            dp[i][1] = (dp[i-2][0] + dp[i-1][1])%M;
        }
        return (int)dp[N][0];
    }
}
