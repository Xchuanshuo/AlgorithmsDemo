package leetcode;

/**
 * @author Legend
 * @data by on 21-5-1.
 * @description https://leetcode-cn.com/problems/divisor-game/
 * idea:
 *      dp[i]表示对于数字i 先手玩家能否赢 状态 对于数字i的因子j
 *      若满足取完一个因子后, 后手必输 则先手必赢 即
 *      dp[i] = (i%j==0) && !dp[i-j]
 */
public class Test1025 {

    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= i / 2;j++) {
                if (i%j == 0 && !dp[i-j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
