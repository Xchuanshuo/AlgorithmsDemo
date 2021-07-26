package leetcode;

/**
 * @author Legend
 * @data by on 21-6-23.
 * @description https://leetcode-cn.com/problems/k-inverse-pairs-array/
 * idea:
 *      用dp[i][j]表示前i个元素, 组成k个逆序对数组的排列方案数
 *      加入当前的元素i, 形成j个逆序对, 则当前状态直接由dp[i-1][j-m]转移过来
 *      其中m表示新加入元素i后 形成的逆序对个数 对于元素i的位置 由i个选择, 如
 *      (3,2,1) 加入4, 放到末尾, 逆序对个数不变；放到1前面, 逆序对+1；放到2前面
 *      逆序对+2...， 以此类推. 所以需要枚举放入的点, 才知道j个逆序对 是由j-m个转移
 *      过来, 这里可以采用数列的错位相减法, 最后得出公式
 *      dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-i]
 *
 *      初始条件 dp[i][0] 即前i个元素 组成0个逆序对的方案数为1
 */
public class Test629 {

    public int kInversePairs(int n, int k) {
        int M = (int)1e9 + 7;
        int[][] dp = new int[n+1][k+1];
        dp[1][0] = 1;
        for (int i = 2;i <= n;i++) {
            dp[i][0] = 1;
            for (int j = 1;j <= k;j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%M;
                if (i <= j) {
                    dp[i][j] = (dp[i][j] - dp[i-1][j-i] + M)%M;
                }
            }
        }
        return dp[n][k];
    }
}
