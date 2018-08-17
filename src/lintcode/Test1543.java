package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description unique-path-iv
 * idea:
 *      dp问题 与unique-path道理一样
 *      只是这里的路径数来自左边、左上，左下的路径数的和
 *      这里需要注意的一点是 因为是从左上角遍历到右上角
 *      所以实现时把height放到内循环 否则遍历到第一行时就遍历到了终点
 *      实际上遗漏了往下走的计算
 */
public class Test1543 {

    public int uniquePath(int height, int width) {
        // Write your code here
        int MOD = 1000000007;
        int[][] dp = new int[height+1][width+1];
        dp[0][0] = 1;
        for (int j=1;j<=width;j++) {
            for (int i=1;i<=height;i++) {
                if (i==height) {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-1])%MOD;
                } else {
                    dp[i][j] = ((dp[i][j-1] + dp[i-1][j-1])%MOD + dp[i+1][j-1])%MOD;
                }
            }
        }
        return dp[1][width];
    }
}
