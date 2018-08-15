package lintcode;

/**
 * @author Legend
 * @data by on 18-8-15.
 * @description jump-game
 * idea:
 *      贪心算法 每次选取能跳跃到的最大值 如果i比最大值还大
 *      说明 当前跳到了为最多步数为0的位置, 就无法跳出去了
 */
public class Test116 {

    public boolean canJump(int[] A) {
        // write your code here
        if (null==A || A.length==0) return false;
        int[] dp = new int[A.length];
        int curMax = 0;
        for (int i=0;i<A.length;i++) {
            if (curMax < i) return false;
            dp[i] = A[i]+i;
            curMax = Math.max(curMax, dp[i]);
        }
        return true;
    }
}
