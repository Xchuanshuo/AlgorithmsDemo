package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description stone-game-ii
 * idea:
 *      dp 和stone-game(Test476)解法一样 但这道题增加了这个stone堆是环的情况
 *      也就是说最后一个和第一个是相连的 这里就需要用到一个trick 把原来的n变成2n
 *      这样首尾就相连了 实现时需要注意的是因为是环 所以对于2n长度的stone堆来说
 *      在任意一个地方i都可以切断 切断后 终点的位置就是i+n-1 比较看哪种方法最小
 */
public class Test593 {

    public int stoneGame2(int[] A) {
        // write your code here
        if (A==null || A.length==0) return 0;
        int n = A.length;
        int[][] dp = new int[n*2][n*2];
        int[] sum = new int[n*2+1];
        for (int i=1;i<=n*2;i++) {
            sum[i] = sum[i-1] + A[(i-1)%n];
        }
        for (int len=2;len<=n;len++) {
            for (int i=0;i<=n*2-len;i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i;k<j;k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
                }
                dp[i][j] += sum[j+1] - sum[i];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {
            result = Math.min(result, dp[i][i+n-1]);
        }
        return result;
    }
}
