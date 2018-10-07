package lintcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-7.
 * @description dices-sum
 * idea:
 *      dp 用dp[i][j]表示i个骰子和为j时出现的频次 而n个骰子和最小为n 最大为n*6
 *      所以只需要求出n个骰子从【n..n*6】访问的和即可 初始条件下 1个筛子和为j([1..6])时
 *      出现的频次都为1 对于dp[i][j] 只需要知道前i-1个骰子和为j-k(k->[1..min(j,6])时
 *      出现的频次 就相当于已经有i-1个骰子了 再来1个骰子 可能扔出结果k 明白这一点就可以
 *      得出状态转移方程 dp[i][j] += dp[i-1][j-k] 求出全部可能的频次后 再求出这些频次的
 *      总和 再用每一个频次除以总和 就得出对应的概率了
 */
public class Test20 {

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        int face = 6, maxSum = face * n;
        long[][] dp = new long[n+1][maxSum+1];
        for (int j=1;j<=face;j++) {
            dp[1][j] = 1;
        }
        for (int i=2;i<=n;i++) {
            for (int j=i;j<=maxSum;j++) {
                for (int k=1;k<=j && k<=face;k++) {
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double totalSum = 0;
        for (int i=n;i<=maxSum;i++) {
            totalSum += dp[n][i];
        }
        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
        for (int i=n;i<=maxSum;i++) {
            result.add(new AbstractMap.SimpleEntry<>(i, dp[n][i]/totalSum));
        }
        return result;
    }
}
