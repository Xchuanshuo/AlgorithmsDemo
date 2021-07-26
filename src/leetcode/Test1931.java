package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Legend
 * @data by on 21-7-11.
 * @description https://leetcode-cn.com/problems/painting-a-grid-with-three-different-colors/
 * idea:
 *      dp 因为m<=5, 所以可以先求出1列满足条件的所有的状态,
 *      求状态可以直接使用dfs, 或者使用3进制数来列举所有状态
 *
 *      dp[i][j]表示前i列, 状态为j时的 方案总数, 对于当前列i
 *      枚举所有状态j, 列举前面的状态k, 需满足两种状态不存在颜色相邻的情况即可
 *      可以得出状态转移方程 dp[i][j] += dp[i-1][k];
 *      初始条件: dp{0}=1, 即第0列 只有为任意状态j时的1种方案
 *      结果: sum(dp[n-1][0], dp[n-1][1], ..., dp[n-1][k])
 *           即前n-1列, 所有不同染色方案的总和
 */
public class Test1931 {

    List<int[]> states = new ArrayList<>();
    public int colorTheGrid(int m, int n) {
        int count = (int)Math.pow(3, m);
        int M = (int)1e9 + 7;
        for (int i = 0;i < count;i++) {
            int num = i, j = 0;
            int[] state = new int[m];
            boolean ok = true;
            while (num != 0) {
                int cur = num%3;
                num /= 3;
                if (m > 1 && j > 0 && cur == state[j-1]) {
                    ok = false; break;
                }
                state[j++] = cur;
            }
            if (j == m || (ok && isValid(state))) states.add(state);
        }
        int[][] dp = new int[n][states.size()];
        Arrays.fill(dp[0], 1);
        for (int i = 1;i < n;i++) {
            for (int j = 0;j < states.size();j++) {
                for (int k = 0;k < states.size();k++) {
                    if (k == j) continue;
                    if (isValid(j, k)) {
                        dp[i][j] = (dp[i][j] + dp[i-1][k])%M;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0;i < states.size();i++) {
            res = (res + dp[n-1][i])%M;
        }
        return res;
    }

    private boolean isValid(int[] state) {
        for (int k = 1;k < state.length;k++) {
            if (state[k] == state[k-1]) return false;
        }
        return true;
    }

    private boolean isValid(int i, int j) {
        for (int k = 0;k < states.get(i).length;k++) {
            if (states.get(i)[k] == states.get(j)[k]) {
                return false;
            }
        }
        return true;
    }
}
