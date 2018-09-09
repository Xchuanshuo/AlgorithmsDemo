package lintcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 18-9-9.
 * @description largest-plus-sign
 * idea:
 *      dp 这道题首先建立一个二维矩阵 把矩阵里面的每个值赋为N，然后把mines位置的值修改为
 *      0 接着从四个方向开始遍历 每次比较 若该位置不为0 就把对应方向的值递增 并且记录当前
 *      +号的最长的边长 最后再遍历整张表 取最大值
 */
public class Test1044 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // Write your code here
        int[][] dp = new int[N][N];
        for (int[] i: dp) {
            Arrays.fill(i, N);
        }
        for (int[] m: mines) {
            dp[m[0]][m[1]] = 0;
        }
        for (int i=0;i<N;i++) {
            for (int j=0, k=N-1, l=0, r=0, u=0, d=0;j<N;j++, k--) {
                dp[i][j] = Math.min(dp[i][j], l=(dp[i][j]==0?0: l+1));
                dp[i][k] = Math.min(dp[i][k], r=(dp[i][k]==0?0: r+1));
                dp[j][i] = Math.min(dp[j][i], u=(dp[j][i]==0?0: u+1));
                dp[k][i] = Math.min(dp[k][i], d=(dp[k][i]==0?0: d+1));
            }
        }
        int result = 0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
