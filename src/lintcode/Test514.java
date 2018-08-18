package lintcode;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description paint-fence
 * idea:
 *      dp　假设dp[n][0]表示结尾不相等　dp[n][1]表示结尾相等
 *      现在要求dp[n][0]，就要从dp[n-1][0]和dp[n-1][1]中去取
 *      对于dp[n-1][0]和dp[n-1][1]实际都是k-1中取法　只要和结尾颜色不相等即可
 *      此时dp[n][0]=(k-1)*(dp[n-1][0]+dp[n-1][1]);然后要求dp[n][1]的话，
 *      也是从前面两个去取,此时对于dp[n-1][0]只有一种取法　那就是直接和它的结尾颜色相等
 *      而对于dp[n-1][1]　因为结尾两颜色已经相等了　所以不能再取相等 所以取法就是0种.
 *      此时 dp[n][1] = dp[n-1][0] 这里的话还可以使用滚动数组来优化　因为只需要根据前面的
 *      情况计算当前的　并且情况只有两种　所以空间可以优化成常数级别的　结果只需合并相等和不相等的情况
 */
public class Test514 {

    public int numWays(int n, int k) {
        // write your code here
        if (n<=0 || k<=0) return 0;
        int same=0, diff=k;
        for (int i=1;i<n;i++) {
            int temp = diff;
            diff = (same+diff)*(k-1);
            same = temp;
        }
        return same + diff;
    }
}
