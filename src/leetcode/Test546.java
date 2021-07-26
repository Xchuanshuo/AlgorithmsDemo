package leetcode;

/**
 * @author Legend
 * @data by on 21-6-20.
 * @description https://leetcode-cn.com/problems/remove-boxes/
 * idea:
 *      因为颜色相同的盒子可以不连续, 所以消除的方式光用变量[i,j]来表示左右
 *      区间, 没办法考虑到所有情况, 至少得还需要第三个变量. 对于此类问题, 基本
 *      的思路是选定一个序列, 接着将序列两边或中间的区间[固定], 也就是看成一个子问题
 *
 *      这里dp[i][j][k]表示区间[i,j]且j右边有k个和boxes[j]颜色相同的盒子,
 *      枚举所有长度的区间, 因为消除的是序列, 所以对于位置j 可以选择右边任意个数相同
 *      颜色的盒子进行合并, 所以还需要枚举个数k, 对于当前状态 dp[i][j][k]
 *      有两种策略  1.将位置j的盒子与右边k个相同颜色的盒子一起消除, 此时左边看成一个整体
 *                   积分为 dp[i][j-1][0] + (k+1)*(k+1)
 *                2.枚举区间[i,j-1]中的与j相同颜色的盒子t, 将t与j作为同一方案中的盒子一起消除,
 *                  此时积分由左右两边组成 右半部分: dp[t+1][j-1][0]
 *                                     左半部分: dp[i][t][k+1]
 *
 *      最终结果, dp[0][n-1][0]即区间[0,n-1]右边没有任何盒子与n-1颜色相同时的最大积分
 */
public class Test546 {

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[] cnts = new int[n];
        for (int i = 0;i < n;i++) {
            int cnt = 0;
            for (int j = i + 1;j < n;j++) {
                if (boxes[j] == boxes[i]) cnt++;
            }
            cnts[i] = cnt;
        }
        int[][][] dp = new int[n][n][101];
        for (int len = 1;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j =  i + len - 1;
                for (int k = 0;k <= cnts[j];k++) {
                    if (len == 1) {
                        dp[i][j][k] = Math.max(dp[i][j][k],
                                (j-1<0?0: dp[i][j-1][0]) + (k + 1) * (k + 1));
                    } else {
                        for (int t = i;t < j;t++) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][0] + (k+1)*(k+1));
                            if (boxes[t] == boxes[j]) {
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[t+1][j-1][0] + dp[i][t][k+1]);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n-1][0];
    }
}
