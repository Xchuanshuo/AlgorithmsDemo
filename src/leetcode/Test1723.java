package leetcode;

/**
 * @author Legend
 * @data by on 21-5-8.
 * @description https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 * idea:
 *      状压DP, 1.先计算所有不同选取方案所需要的总时间
 *             2.dp[i][j]表示状态为i,j个人时需要的最大时间的最小值
 *             3.枚举所有状态,以及对于不同状态的分割方式,求当前的最大值, 采取某种分割方式后
 *               在前j-1个人完成i-s个任务 与 第j个人完成s个任务所需时间取较大值, 即
 *               max(dp[i-s][j-1],times[s]) 对与当前所有的分割方式 取所有较大值中的最小值
 *             4. 初始状态: dp[i][1] 1个人完成任意个数任务的时间等于这些任务时间的总和
 *                结果: dp[(1<<n)-1][k] 即 消耗k个人 所有任务都选取后所需的最少时间
 */
public class Test1723 {

    public int minimumTimeRequired(int[] jobs, int k) {
        int n =  jobs.length;
        int[] times = new int[1<<n];
        for (int i = 0;i <= (1 << n)-1;i++) {
            for (int j = 0;j < n;j++) {
                if ((i&(1<<j)) == 0) continue;
                times[i] += jobs[j];
            }
        }
        int[][] dp = new int[1<<n][k+1];
        for (int i = 0;i < (1<<n);i++) {
            dp[i][1] = times[i];
        }
        for (int j = 2;j <= k;j++) {
            for (int i = 0;i < (1<<n);i++) {
                int min = Integer.MAX_VALUE;
                for (int s = i;s > 0;s = i&(s-1)) {
                    int max= Math.max(dp[i - s][j-1], times[s]);
                    min = Math.min(min, max);
                }
                dp[i][j] = min;
            }
        }
        return dp[(1<<n)-1][k];
    }
}
