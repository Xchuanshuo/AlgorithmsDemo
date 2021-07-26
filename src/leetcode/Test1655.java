package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 21-5-8.
 * @description https://leetcode-cn.com/problems/distribute-repeating-integers/
 * idea:
 *      状压DP. 本题与nums具体的数字无关, 只需要统计每个数字出现的次数 然后
 *             1.穷举quantity中订单的所有不同的组合情况
 *             2.用dp[i][j]表示对于组合i,使用j种数字,能否进行分配
 *             3.对于状态i枚举它的所有子集, 假设用s表示i的某个子集,对于组合i,使用j种数字要能分配
 *               需满足 (i-s,j-1)可以分配, 且当前数字的数量比子集需要的数量要大或相等,
 *               即状态转移方程为 dp[i][j] = dp[i-s][j-1] & orders[s] <= cnt[j]
 *               对于某个组合i,如果用前j-1种数字就能满足情况 多加1种数字肯定也是满足的 则无需在继续分割
 *             4.初始条件: dp[0][i..n]=true, 即订单数为0时 任意的数字个数都能满足
 */
public class Test1655 {

    public boolean canDistribute(int[] nums, int[] quantity) {
        int m = quantity.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int[] orders = new int[1<<m];
        for (int i = 0;i < (1<< m);i++) {
            for (int j = 0;j < m;j++) {
                if ((i&(1<<j)) == 0) continue;
                orders[i] += quantity[j];
            }
        }
        int n = map.size();
        boolean[][] dp = new boolean[1<<m][n+1];
        for (int i = 0;i <= n;i++) dp[0][i] = true;
        int j = 1;
        for (int key: map.keySet()) {
            int cnt = map.get(key);
            for (int i =  0;i < (1 << m);i++) {
                if (j>0 && dp[i][j-1]) {
                    dp[i][j] = true;continue;
                }
                for (int s = i;s > 0;s = i&(s-1)) {
                    if (dp[i-s][j-1] && orders[s] <= cnt) {
                        dp[i][j] = true; break;
                    }
                }
            }
            j++;
        }
        return dp[(1<<m)-1][n];
    }
}
