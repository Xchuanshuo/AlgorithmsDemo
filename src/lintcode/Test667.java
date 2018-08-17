package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description
 * idea:
 *      dp 这里dp[i][j]表示i..j范围内最大的回文序列是多大
 *      对于每个字符i..i来说 回文序列就是本身 长度为1 要求i..j范围内最大的回文序列
 *      就需要知道i+1..j-1范围内的最大回文序列是多大 很显然这是我们在前一次变遍历时已经求出的
 *      所以这里就需要判断 i和j所在的字符是否相等 如果相等 那么i..j范围又构成了新的回文序列
 *      此时dp[i][j]=dp[i+1][j-1]+2;如果不相等 那么当前i..j范围的最大回文序列的长度
 *      就在i+1..j或i..j-1范围内取 此时dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1])
 */
public class Test667 {

    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s==null || s.length()==0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i=n-1;i>=0;i--) {
            dp[i][i] = 1;
            for (int j=i+1;j<n;j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
