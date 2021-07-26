package leetcode;


/**
 * @author Legend
 * @data by on 21-4-30.
 * @description https://leetcode-cn.com/problems/profitable-schemes/
 * idea:
 *      多维的0-1背包 用dp[k][i][j]表示前k个任务 i个人 利润为j时的方案数 对于当前任务k,
 *      只有两种可能, 选与不选 不选的话从前k-1个任务转移过来 选的话从为
 *      dp[k-1][i-g][j-p], 其中g,p为本次任务的人数 利润, 需要注意的是由于这里是求
 *      满足最小利润的方案, 对于大于最小利润的 统一当成 最小利润处理即可
 *      最后统计所有可选人数 利润大于 最小利润的方案总和即可
 *
 *      类似0-1背包,当前状态只依赖于上一轮的状态 所以可以将空间从三维优化成二维. 因为不可重复取
 *      需要从后往前计算, 这样用到的都是上一轮的状态
 *
 */
public class Test879 {

    private int M = (int)1e9 + 7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n+1][minProfit + 1];
        long res = 0;
        dp[0][0] = 1;
        for (int k = 0;k < group.length;k++) {
            int g = group[k], p = profit[k];
            for (int i = n;i >= g;i--) {
                for (int j = minProfit;j >= 0;j--) {
                    dp[i][j] = (dp[i][j] + dp[i-g][Math.max(j-p, 0)])%M;
                }
            }
        }
        for (int i = 0;i <= n;i++) {
            res = (res + dp[i][minProfit])%M;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Test879 test = new Test879();
        int res = test.profitableSchemes(5, 3, new int[]{2,2}, new int[]{2,3});
//        int res = test.profitableSchemes(10, 5, new int[]{2,3,5}, new int[]{6,7,8});
        System.out.println(res);
    }
}
