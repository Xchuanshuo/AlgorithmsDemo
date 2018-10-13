package lintcode;

/**
 * @author Legend
 * @data by on 18-10-13.
 * @description put-box
 * idea:
 *      区间型dp  dp[i][j]表示前i个盒子存放前j个位置最大的数量 当box[i]<=pos[j]时
 *      表示能存放 此时 dp[i][j]=dp[i-1][j-1]+1;
 *                否则dp[i][j]=max(dp[i-1][j], dp[i][j-1])
 */
public class Test1541 {

    public int putBox(int[] box, int[] position) {
        // Write your code here
        int m = box.length, n = position.length;
        int[][] dp  = new int[m+1][n+1];
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (box[i-1]<=position[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
