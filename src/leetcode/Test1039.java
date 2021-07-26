package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-29.
 * @description https://leetcode-cn.com/problems/minimum-score-triangulation-of-polygon/
 * idea:
 *      dp[i][j]表示以区间[i,j]区间的数为顶点的凸多边形进行三角剖分后可以得到的最低分
 *      枚举所有区间 当长度为2时 不能构成三角形 得分为0 当长度为3时 三个顶点刚好构成三角形
 *      当长度大于3时 枚举分割点 画图可以得到规律 以一个点k为分割点 可以得出的新三角形的三个
 *      顶点分别为 v[i] v[k] v[j] 相乘即可 总的得分为
 *      dp[i][j] = dp[i][k] + dp[k][j] + v[i]*v[k]*v[j]
 */
public class Test1039 {

    public int minScoreTriangulation(int[] v) {
        int n = v.length;
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (len == 2) {
                    dp[i][j] = 0;
                } else if (len == 3) {
                    dp[i][j] = v[i] * v[i+1] * v[j];
                } else {
                    for (int k = i + 1;k < j;k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + v[i]*v[k]*v[j] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
