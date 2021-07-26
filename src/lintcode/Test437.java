package lintcode;

/**
 * @author Legend
 * @data by on 20-3-16.
 * @description copy-books
 * idea:
 *      用dp[i][j]表示i个人复制j本书籍所花费的最小时间 那么如何求dp[i][j]呢？
 *      重点在于找到前一个状态, 也就是前i-1个人复制多少本书籍 和第i个人复制多少书籍
 *      能使得花费的时间最少 也就是说两者之间复制完书籍时结束时间相差较少 要求这个最小值
 *      只能枚举0..j-1 本书籍的不同分配情况下所占用的时间 因为题目规定了一个人只能复制
 *      连续的多本书籍 所以可以先求书籍页数的前缀和 并保存到一个数组 这样进行枚举时 就
 *      可以快速得出1个人复制连续几本书籍时需要的时间花费 这里假设以c为分界点，即总共j本
 *      书时 前i-1个人复制的是前0..c本书, 则前i-1个人所需时间是dp[i-1][c] 而第i个人复制的是
 *      c..j这几本书则第i个人所需的时间是prefix[j] - prefix[c] 其中prefix保存的就是前缀和
 *      即得出了状态转移方程 dp[i][j] = min(dp[i][j], max(dp[i-1][c], pages[c]+...+pages[j]))
 */
public class Test437 {

    public int copyBooks(int[] pages, int k) {
        int n = pages.length;
        int[][] dp = new int[k+1][n+1];
        int[] prefix = new int[n+1];
        for (int i = 1;i <= n;i++) {
            dp[0][i] = Integer.MAX_VALUE;
            prefix[i] = prefix[i - 1] + pages[i-1];
        }
        for (int i = 1;i <= k;i++) {
            for (int j = 1;j <= n;j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int c = 0;c < j;c++) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.max(dp[i-1][c], prefix[j] - prefix[c]));
                }
            }
        }
        return dp[k][n];
    }
}
