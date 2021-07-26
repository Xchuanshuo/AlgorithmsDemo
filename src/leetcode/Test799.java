package leetcode;

/**
 * @author Legend
 * @data by on 21-5-14.
 * @description https://leetcode-cn.com/problems/champagne-tower/
 */
public class Test799 {

    public double champagneTower(int poured, int row, int column) {
        double[][] dp = new double[100][100];
        dp[0][0] = poured;
        for (int i = 0;i < row;i++) {
            for (int j = 0;j <= i;j++) {
                double cur = dp[i][j];
                if (cur <= 1.0) continue;
                dp[i][j] = 1.0;
                double dif = cur - 1.0;
                if (i+1 < 100) {
                    dp[i+1][j] += dif * 0.5;
                    if (j+1<100)  dp[i+1][j+1] += dif*0.5;
                }
            }
        }
        return Math.min(dp[row][column], 1.0);
    }
}
