package lintcode;

/**
 * @author Legend
 * @data by on 18-8-14.
 * @description longest-common-subsequence
 * idea:
 *      经典的dp问题 用一个二维数组dp[i][j] 表示前i个字符配上前j个字符的LCS
 *      如果两个字符相等 则更新当前长度为前面dp[i-1][j-1]+1, 也就是当前LCS
 *      为两个字符串前面的LCS加上当前的；如果不相等，就取dp[i-1][j]和dp[i][j-1]
 *      中的较大长度
 *
 */
public class Test77 {

    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int[][] dp = new int[A.length()+1][B.length()+1];
        for (int i=1;i<=A.length();i++) {
            for (int j=1;j<=B.length();j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
