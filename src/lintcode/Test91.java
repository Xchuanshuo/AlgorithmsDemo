package lintcode;

import java.util.List;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description minimum-adjustment-cost
 * idea:
 *      dp问题 dp[i][j]表示 把位置i的值修改为j所需的最小花费
 *      因为这里的最小花费需要通过计算两个数的改变值来计算 所以需要用3层循环
 *      位置i的值修改为j需要的最小花费取决于 前面第i-1个数所需要的最小花费+某次修改的值
 *      所以可以得到状态转移方程为 dp = Math.abs(A[i]-j)+dp[i-1][k]
 *      前提条件是满足代价差 即j-k<=target
 */
public class Test91 {

    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        if (A==null || A.size()<=1) return 0;
        int n = A.size();
        int[][] dp = new int[n+1][101];
        for (int i=1;i<=n;i++) {
            for (int j=0;j<101;j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=0;k<101;k++) {
                    if (Math.abs(j-k) > target) continue;
                    int cur = Math.abs(A.get(i-1)-j) + dp[i-1][k];
                    dp[i][j] = Math.min(dp[i][j], cur);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i=0;i<101;i++) {
            result = Math.min(result, dp[n][i]);
        }
        return result;
    }
}
