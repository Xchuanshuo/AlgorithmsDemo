package leetcode;

/**
 * @author Legend
 * @data by on 21-5-15.
 * @description https://leetcode-cn.com/problems/new-21-game/
 * idea:
 *      dp[i]表示当前分数为i分时, 分数不超过N分的概率
 *      当分数大于等于k分时停止抽取, 对于大于等于k分时 分为两种情况
 *      1.总分大于N, 那此时概率0   2.总分小于等于n 概率为1
 *      当没有停止抽取, 即分数i为[0..k-1]分时, 分数不超过N的概率为
 *      1/w * sum(dp[i+1],dp[i+w+1]), 即累加i分+w分后所有的概率 * 1/w
 *      对于当前分数i,最多累加到i+w分的总分, 所以对于累加的过程 实际相当于维护
 *      一个大小为w的滑动窗口, 当前计算完后 把上一轮的右端点移除, 当前变成左端点
 *      即 窗口整体左移 用作下一轮的计算
 *      结果 dp[0] 即为当前分数为0分时 抽取多次数字后不超过N的概率
 */
public class Test837 {

    public double new21Game(int n, int k, int w) {
        double[] dp = new double[k + n + w + 1];
        for (int i = k;i <= n;i++) dp[i] = 1.0;
        double total = 0;
        for (int i = k;i < k + w;i++) total += dp[i];
        for (int i = k-1;i >= 0;i--) {
            dp[i] = total / w;
            total = total + dp[i] - dp[i+w];
        }
        return dp[0];
    }
}
