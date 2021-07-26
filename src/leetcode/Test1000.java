package leetcode;

import tree.heap.Array;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-27.
 * @description https://leetcode-cn.com/problems/minimum-cost-to-merge-stones/
 * idea:
 *      dp[i][j][k] 表示将区间第[i,j]的石头合并成k堆的最小成本 则合并成
 *      1堆 dp[i][j][1] = dp[i][j][k] + sum(i,j) (区间i..j的成本总和)
 *      枚举所有不同长度的区间, 以及合成的堆数 假设需要合成m堆(2 <= m <= k) 则
 *      dp[i][j][m] = dp[i][j][1] + dp[i][j][m-1] 还需要枚举合成的分界点 假设为p
 *      则 dp[i][j][m] = dp[i][p][1] + dp[p+1][j][m-1]
 *
 *      初始状态: 每个石头合成1堆的成本等于0 即 dp[i][i][1] = 0
 *      最终结果 dp[1][n][1]
 *
 *      不能合成: 首先要全部合成1堆 得全部合成k堆, 由最后的k堆可以反推出石头的总数
 *      即 n = k + (k-1)*a (其中a为大于等于0的[整数], 因为每次将k个石头合成1堆 相当于总数 减少了 k-1)
 *      n-1 = k + (k-1)*a - 1, 即 n-1 = (k-1) * (a+1) 可以得出(n-1)%(k-1) = 0
 *      所以 不满足这个等式说明不能合成最终的结果
 */
public class Test1000 {

    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n-1) % (K-1) != 0) return -1;
        int[][][] dp = new int[n][n][K+1];
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) {
            sum[i+1] = sum[i] + stones[i];
        }
        for (int[][] d2 : dp) {
            for (int[] d1 : d2) Arrays.fill(d1, Integer.MAX_VALUE);
        }
        for (int i = 0;i < n;i++) {
            dp[i][i][1] = 0;
        }
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n-len;i++) {
                int j = i + len - 1;
                for (int m = 2;m <= K;m++) {
                    for (int p = i;p < j;p+=K-1) {
                        dp[i][j][m] = Math.min(dp[i][j][m], dp[i][p][1] + dp[p+1][j][m-1]);
                    }
                }
                dp[i][j][1] = dp[i][j][K] + sum[j+1] - sum[i];
            }
        }
        return dp[0][n-1][1];
    }

    public static void main(String[] args) {
//        int[] stones = {3,2,4,1};
        int[] stones = {3,5,1,2,6};
        int K = 3;
        Test1000 test = new Test1000();
        int res = test.mergeStones(stones, K);
        System.out.println(res);
    }
}
