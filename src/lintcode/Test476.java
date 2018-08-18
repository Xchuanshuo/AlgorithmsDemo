package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description stone-game
 * idea:
 *      dp dp[i][j]表示归并从i到j的stone所需要的最小代价和
 *      这里首先需要计算每个位置和前面的stone的代价和
 *      初始状态下没和任何石子进行归并 dp[i][i]=0 合并过程中
 *       如dp[3][5]= dp[3][4]+dp[5][5]+sum[3,5]
 *        dp[3][5] = dp[3][3]+dp[4][5]+sum[3,5]
 *        dp[3][4] = dp[3][3]+dp[4][4]+sum[3,4] .. 以此类推
 *       得出状态转移方程 dp[i][j] = min(dp[i][j], dp[i][k]+dp[k+1][j]+sum[i,j])
 *       其中k属于i..j 最终返回dp[0][n]
 */
public class Test476 {

    public int stoneGame(int[] A) {
        // write your code here
        if (A==null || A.length==0) return 0;
        int n = A.length;
        int[][] dp = new int[n+1][n+1];
        int[] sum = new int[n+1];
        for (int i=1;i<=n;i++) {
            sum[i] = sum[i-1] + A[i-1];
        }
        for (int i=n-2;i>=0;i--) {
            for (int j=i+1;j<n;j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i;k<j;k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
                }
                dp[i][j] += sum[j+1] - sum[i];
            }
        }
        return dp[0][n-1];
    }
}
