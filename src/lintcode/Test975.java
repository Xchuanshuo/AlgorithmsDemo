package lintcode;
/**
 * @author Legend
 * @data by on 18-9-8.
 * @description 2-keys-keyboard
 * idea:
 *      dp 与4-keys-keyboard(Test867)类似 不过这个地方是求打印出n需要的最小步数
 *      用dp[i]表示打印出i个A所需要的最小步数 要求dp[i] 就要求在某个位置j开始进行粘贴
 *      可获得的次数+j次(包括j-1次和1次复制) 同样的 求这个位置就也需要穷举 可以得出状
 *      态转移方程  dp[i]=min(dp[i], dp[i/j]+j)
 */
public class Test975 {

    public int minSteps1(int n) {
        int[] dp = new int[n+1];
        for (int i=2;i<=n;i++) {
            dp[i] = i;
            for (int j=2;j<=i/2;j++) {
                if (i%j == 0) {
                    dp[i] = Math.min(dp[i], dp[i/j]+j);
                }
            }
        }
        return dp[n];
    }

    public int minSteps2(int n) {
        // Write your code here
        int result = n;
        for (int i=2;i<=n;i++) {
            if (n%i == 0) {
                result = Math.min(result, minSteps2(n/i)+i);
            }
        }
        return result;
    }
}
