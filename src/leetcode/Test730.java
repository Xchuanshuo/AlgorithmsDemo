package leetcode;

/**
 * @author Legend
 * @data by on 21-4-28.
 * @description https://leetcode-cn.com/problems/count-different-palindromic-subsequences/
 * idea:
 *      去重思路类似 Test940 因为这里是区间dp, 用dp[i][j][k]表示在区间[i,j]内 以字符k开始的
 *      回文子序列个数 枚举从2开始到字符串长度n的区间大小,
 *      1.若s[i] = s[j] 则 dp[i][j][s[i]] = sum(dp[i+1][j-1][0..3]) + 2, 含义是对于区间[i,j]
 *      内的以字符s[i]开始的回文序列个数为 区间[i+1,j-1]内任意字符开始的回文序列. 添加上首尾两个字符
 *      由于首尾两个字符相等 可以组成1个回文序列, s[i]字符本身也可以当作1个回文序列 所以要 + 2
 *
 *      2.若s[i]!=s[j], 则去掉字符s[i]后, 以字符s[j]开始的回文序列 即dp[i][j][s[j]] = dp[i+1][j][s[j]]
 *                       去掉字符s[j]后, 以字符s[i]开始的回文序列 即dp[i][j][s[i]] = dp[i][j-1][s[i]]
 *
 *      对于区间[i,j]除了端点的字符开始的回文序列, 其它字符开始的回文序列 直接从区间[i+1,j-1]继承过来即可
 */
public class Test730 {

    final int M = (int)1e9 + 7;
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        char[] chars = S.toCharArray();
        long[][][] dp = new long[n][n][4];
        for (int i = 0;i < n;i++) {
            dp[i][i][chars[i] - 'a'] = 1;
        }
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                for (int k = 0;k < 4;k++) dp[i][j][k] = dp[i+1][j-1][k];
                if (chars[i] == chars[j]) {
                    dp[i][j][chars[i] -'a'] = (sum(dp[i+1][j-1]) + 2)%M;
                } else {
                    dp[i][j][chars[i] - 'a'] = dp[i][j-1][chars[i] - 'a'];
                    dp[i][j][chars[j] - 'a'] = dp[i+1][j][chars[j] - 'a'];
                }
            }
        }
        return (int)sum(dp[0][n-1])%M;
    }

    private long sum(long[] dp) {
        return (dp[0] + dp[1] + dp[2] + dp[3])%M;
    }
}
