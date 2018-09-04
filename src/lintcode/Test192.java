package lintcode;

/**
 * @author Legend
 * @data by on 18-9-4.
 * @description wildcard-matching
 * idea:
 *      dp 这里用dp[i][j]表示字符串s的前i个字符与字符串p的前j个字符是否匹配
 *      这里如果dp[i][j]要匹配有几种情况 如果字符串p的j位置为*号 那么只需要满足
 *      字符串s的前i-1个字符串和字符p的前j个字符串匹配 或者 字符串s的前i个字符串
 *      和字符串p的前j-1个字符串匹配; 此时状态转移方程为
 *          dp[i][j] = dp[i-1][j] || dp[i][j-1]
 *      如果字符串p中的j位置不为*号，那么需要s的前i-1个字符和p的前j-1个字符匹配，并
 *      且 满足字符串s[i]==p[j]或者p的第j位置为?号 此时状态转移方程为
 *          dp[i][j] = (s[i]==p[j]||p[j]='?') && dp[i-1][j-1]
 *      最后注意初始条件 s和p没有任何字符串时二者是匹配的 并且s字符串为空串，字符串p的
 *      前0..j位为*时 二者也是匹配的
 */
public class Test192 {

    public boolean isMatch(String s, String p) {
        // write your code here
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j=1;j<=n;j++) {
            if (p.charAt(j-1)=='*') {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (p.charAt(j-1)=='*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
