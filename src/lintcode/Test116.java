package lintcode;

/**
 * @author Legend
 * @data by on 18-8-15.
 * @description jump-game
 * idea:
 *      1.动态规划 题目要求的问题是能否到达最后一个位置 假设为i
 *        那么子问题就是i前面的位置(假设为j)能否到达 这里用dp[i]表示位置i能否到达
 *        那么要满足i能到达 也就要求dp[j]也是能到达的 并且还要满足从j位置能到达i位置 即 j + A[j] >= i
 *        具体实现的过程直接进行穷举i之前的位置即可 最终状态转移方程 dp[i] = dp[j] && A[j] + j >= i;
 *        注意只要前面某个位置j可达了直接break掉即可 初始条件dp[0] 表示第0可位置是可达的时间复杂度O(n^2)
 *
 *      2.贪心算法 每次选取当前能跳跃到的最大值 如果i比最大值还大
 *        说明 当前跳到了最多步数为0的位置, 就无法跳出去了 时间复杂度O(n)
 */
public class Test116 {

    public boolean canJump1(int[] A) {
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        for (int i = 1;i < A.length;i++) {
            dp[i] = false;
            for (int j = 0;j < i;j++) {
                if (dp[j] && A[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[A.length - 1];
    }

    public boolean canJump2(int[] A) {
        // write your code here
        if (null==A || A.length==0) return false;
        int max = 0, cur;
        for (int i=0;i<A.length;i++) {
            if (max < i) return false;
            cur = A[i]+i;
            max = Math.max(max, cur);
        }
        return true;
    }
}
