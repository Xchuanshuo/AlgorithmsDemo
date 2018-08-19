package lintcode;

/**
 * @author Legend
 * @data by on 18-8-19.
 * @description backpack-ii
 * idea:
 *      背包问题 dp[m]表示大小为m的背包 这里于backpack(Test92)一样, 不过这里
 *      改成了求最大价值
 */
public class Test125 {

    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[] dp = new int[m+1];
        for (int i=0;i < A.length;i++) {
            for (int j=m;j >= A[i];j--) {
                dp[j] = Math.max(dp[j], V[i] + dp[j-A[i]]);
            }
        }
        return dp[m];
    }
}
