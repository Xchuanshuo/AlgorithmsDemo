package leetcode.lcp242;

/**
 * @author Legend
 * @data by on 21-5-23.
 * @description https://leetcode-cn.com/problems/stone-game-viii/
 * idea:
 *      dp[i]表示从[i,n-1]中拿取石头x个后最终先手能比后手多获得的最大分数
 *      因为x>1, 所以i从开始, 而每次拿取x个石头后 将结果放在左边, 所以下次拿
 *      只需要[至少往后一个位置即可] 对于当前位置i，有两种拿法
 *      1.不拿当前石子，从[i+1,n]个石子中拿, 此时得分为dp[i+1]
 *      2.拿当前石子，此时总价值为 sum[i] - dp[i+1] 即先手拿完后的价值 - 之前后手比先手多的价值
 *      (前面为 B - A, 当前为 A - B， 到当前总差值为 A-(B-A))
 *      两者取最大值即当前最优方案
 *
 *      最终结果: dp[1]即先手从[1,n-1]区间内拿 比后手分数的最大值
 */
public class Test5766 {

    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] dp = new int[n];
        int[] sum = new int[n+1];
        for (int i = 0;i < n;i++) sum[i+1] = sum[i] + stones[i];
        dp[n-1] = sum[n];
        for (int i = n - 2;i >= 1;i--) {
            dp[i] = Math.max(dp[i+1], sum[i+1] - dp[i+1]);
        }
        return dp[1];
    }
}
