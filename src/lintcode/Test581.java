package lintcode;

/**
 * @author Legend
 * @data by on 18-8-18.
 * @description longest-repeating-subsequence
 * idea:
 *      dp 这道题是求最长不重复子序列实际上可以转换为求两个字符串的LCS
 *         但是需要过滤掉一个条件 就是两个字符不能是同一个位置 如果是同一个位置
 *         就相当于每个字符与自身 最长的序列是1 1.当位置不相同时 2.且两个字符相等
 *         dp[i][j] = dp[i-1][j-1]+1; 不满足这两个条件 则当前字符串的最长不重复
 *         子序列从前面的状态取最大值 即dp[i][j]=max(dp[i-1][j], dp[i][j-1])
 */
public class Test581 {

    public int longestRepeatingSubsequence(String str) {
        // write your code here
        if (str==null || str.length()==0) return 0;
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                dp[i][j] = 1;
                if (i!=j && str.charAt(i-1)==str.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
