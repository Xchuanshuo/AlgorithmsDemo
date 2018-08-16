package lintcode;

/**
 * @author Legend
 * @data by on 18-8-16.
 * @description perfect-squares
 * idea:
 *      dp问题 dp[i]表示的是使和等于i的最小平方数的个数
 *      每一个数都可以写成是其前面某个数加上一个完美平方数
 *      即 n = a + k 其中a是一个普通数 k是一个完美平方数
 *      且 0<a,k<n 而k对应的值是前面已经求出过的
 *      根据此规律得出递推公式 dp[i]=min(dp[i], dp[i-j*j]+1)
 *      最坏情况下第i个数只能写出i*1^2 即dp[i]=i;
 */
public class Test513 {

    public int numSquares(int n) {
        // write your code here
        int[] dp = new int[n+1];
        for (int i=1;i<=n;i++) {
            dp[i] = i;
            for (int j=1;j*j<=i;j--) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
