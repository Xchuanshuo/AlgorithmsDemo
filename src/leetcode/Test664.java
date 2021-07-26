package leetcode;

/**
 * @author Legend
 * @data by on 21-4-28.
 * @description https://leetcode-cn.com/problems/strange-printer/
 * idea:
 *      dp[i][j]表示区间[i,j]打印的最少次数 枚举所有长度的区间
 *      假设当前左端点字符单独打印 则最少次数为 dp[i][j] = 1 + dp[i+1][j]
 *      枚举区间内所有的元素, 若当前k位置的元素与左端点相等 则可以放在一次任务中打印
 *      即 dp[i+1][k] 或 dp[i][k-1] 含义是 左端点i位置字符和位置k一起打印 或者
 *      k位置字符和左端点一起打印 然后 需要加上k右边区间的次数 即
 *
 *      dp[i][j] = dp[i+1][k] + dp[k+1][j]
 */
public class Test664 {

    public int strangePrinter(String s) {
        int n = s.length();
        if (n  <= 1) return n;
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i++) {
            dp[i][i] = 1;
        }
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                dp[i][j] = 1 + dp[i+1][j];
                for (int k = i + 1;k <= j;k++) {
                    if (chars[i] == chars[k]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][k] + (k+1 < n ? dp[k+1][j] : 0));
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
