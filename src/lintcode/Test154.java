package lintcode;

/**
 * @author Legend
 * @data by on 18-9-4.
 * @description regular-expression-matching
 * idea:
 *      dp 这题与wildcard-matching(Test192)相比 *号的匹配规则由匹配任意字符
 *      变成了匹配前面0个或多个字符 所以这里当字符串p的第j位字符为*时 需要考虑3种情况
 *      当第j-1位字符与第i为字符不相等时(j-1为.号除外) 说明此时*肯定就是0次匹配了 这
 *      时需要看前j-2位字符与字符串s的前i为字符串是否匹配; 当第p的第j-1位字符与s的第i位
 *      字符相等时，就需要看是否满足前面的0次、1次或者多次匹配有成立的情况 其它地方与
 *      wildcard-matching基本一样 还有一点需要注意的是 初始化时 初始的是0次匹配的情况
 *      所以应该是 dp[0][j]=dp[0][j-2]
 */
public class Test154 {

    public boolean isMatch(String s, String p) {
        // write your code here
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j=1;j<=n;j++) {
            if (j>=2 && p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (j>=2 && p.charAt(j-1) == '*') {
                    if (p.charAt(j-2)!='.' && s.charAt(i-1)!=p.charAt(j-2)) {
                        // 0次匹配
                        dp[i][j] = dp[i][j-2];
                    } else {
                        // 3种情况 0次匹配 1次匹配 多次匹配
                        dp[i][j] = dp[i][j-2] || dp[i-1][j] || dp[i-1][j-2];
                    }
                } else {
                    dp[i][j] = (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
