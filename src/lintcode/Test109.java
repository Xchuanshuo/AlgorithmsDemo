package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description triangle
 * idea:
 *      dp问题 这里是从后往前算 dp[i][j]表示位置i，j的最短路径和 、
 *      而dp[i][j]取决与其下方和器左下方的路径和
 *      即 dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1])+cur
 */
public class Test109 {

    public int minimumTotal(int[][] triangle) {
        // write your code here
        int m = triangle.length;

        int[][] f = new int[m][m];

        // 初始化
        for(int i=0;i < m;i++) {
            f[m-1][i] = triangle[m-1][i];
        }
        // f从倒数第二行开始
        for(int i = m - 2; i >= 0; i--) {
            for (int j=0;j <= i;j++) {
                f[i][j] = Math.min(f[i+1][j],f[i+1][j+1]) + triangle[i][j];
            }
        }
        return f[0][0];
    }
}
