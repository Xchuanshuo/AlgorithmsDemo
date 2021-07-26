package leetcode;

/**
 * @author Legend
 * @data by on 21-4-16.
 * @description https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * idea:
 *      dp,首先求出字符串中任意区间是否为回文串 用dp[i][j]表示区间[i,j]是否为回文串
 *      然后对于前i个字符,如果[0,i]为回文串,则长度为i+1的字符最少分割次数为0,即无需分割
 *      否则枚举[0,i]区间前j个位置,[j,i]为回文串,则尝试从当前位置分割
 *      最小次数为前j个字符的最小次数 + 1，所有位置的情况.取最小值
 *      即dp1[i] = min(dp1[i], dp[j-1] + 1)
 */
public class Test132 {

    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0;i < n;i++) dp[i][i] = true;
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <=n - len;i++) {
                int j = i  + len - 1;
                if (s.charAt(i) == s.charAt(j) &&  (len == 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
        int[] dp1 = new int[n];
        for (int i = 0;i < n;i++) dp1[i] = i;
        for (int i = 1;i < n;i++) {
            if (dp[0][i]) {
                dp1[i] = 0; continue;
            }
            for (int j = i;j >= 1;j--) {
                if (dp[j][i]) {
                    dp1[i] = Math.min(dp1[i], dp1[j-1] + 1);
                }
            }
        }
        return dp1[n-1];
    }
}
