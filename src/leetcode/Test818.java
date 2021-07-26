package leetcode;

import tree.heap.Array;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-26.
 * @description https://leetcode-cn.com/problems/race-car/
 * idea:
 *      距离: 0 -> 1 -> 3 -> 7 -> 15... 2^n-1
 *      速度: 1 -> 2 -> 4 -> 8 -> 16... 2^n
 *      用dp[i]表示距离为i时的最小指令长度为多少, 分为3种情况
 *      1.当 i=2^n-1时, 只需要走n步 即 dp[i] = n
 *      2.当 i<2^n-1时, 走n步后 需要回走的距离为 d = 2^n-1 - i, 总步数为 dp[i] = n + 1(R) + dp[d]
 *      3.当 i>2^n-1时, 走n步后 假设回走k步 的距离为kd = 2^k - 1
 *        dp[i] = n + 1(R) + k + 1(R) + dp[i-2^n-1 + kd]
 */
public class Test818 {

    public int racecar(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1;i <= target;i++) {
            for (int f = 1;(1 << f) - 1 < 2 * i;f++) {
                int fd = (1 << f) - 1;
                if (fd == i) { // 情况1
                    dp[i] = Math.min(dp[i], f);
                } else if (fd > i) { // 情况2
                    dp[i] = Math.min(dp[i], f + 1 + dp[fd - i]);
                } else { // 情况3
                    for (int k = 0;k < f;k++) {
                        int kd = (1 << k) - 1;
                        dp[i] = Math.min(dp[i], f+1 + k+1 + dp[i - fd + kd]);
                    }
                }
            }
        }
        return dp[target];
    }
}
