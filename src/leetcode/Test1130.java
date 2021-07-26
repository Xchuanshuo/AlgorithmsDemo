package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-19.
 * @description https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/
 * idea:
 *      dp[i][j]表示区间[i,j]组成的最小代价生成树的叶值
 *      枚举所有区间, 并枚举区间的分界点k, 假设分界点两边分别为
 *      新构造的树的左右子树 对于这颗新的树的代价和为 区间[i,k],
 *      [k+1,j]分别组成的最小代价树的值相加, 并加上左右子树最大叶子节点值的乘积
 *      因为要求任意区间的最大值, 所以可以提前预处理, 保存任意区间的最大值
 *      状态转移方程为: dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + max[i][k]*max[k+1][j])
 *      初始条件: dp[i][i] = 0(0<=i<=n-1), 表示任意单个节点无法组成最小代价树, 代价和为0
 *      结果: dp[0][n-1] 即区间[0,n-1]的所有节点组成的树的最小代价和
 */
public class Test1130 {

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length, INF = (int)1e9;
        int[][] max = new int[n][n];
        for (int len = 1;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (len == 1) {
                    max[i][j] = arr[i];
                } else {
                    max[i][j] = Math.max(max[i][j-1], arr[j]);
                }
            }
        }
        int[][] dp = new int[n][n];
        for (int[] d : dp) Arrays.fill(d, INF);
        for (int i = 0;i < n;i++) dp[i][i] = 0;
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                for (int k = i;k < j;k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]
                            + max[i][k]*max[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
