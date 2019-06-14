package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description triangle
 * idea:
 *      dp问题 这里是从后往前算 dp[i][j]表示位置i，j的最短路径和 、
 *      而dp[i][j]取决与其下方和其左下方的路径和
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

    // 优化到O(N)的空间 其实每次只要比较两个相邻的列位置
    public int minimumTotal2(int[][] triangle) {
        int n = triangle.length;
        int[] dp = new int[n];
        for (int i = 0;i < n ;i++) {
            dp[i] = triangle[n-1][i];
        }
        for (int i = n-2;i >= 0;i--) {
            for (int j = 0;j <= i;j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle[i][j];
            }
        }
        return dp[0];
    }
}
