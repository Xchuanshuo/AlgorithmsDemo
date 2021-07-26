package leetcode;

/**
 * @author Legend
 * @data by on 21-4-27.
 * @description https://leetcode-cn.com/problems/longest-chunked-palindrome-decomposition/
 * idea:
 *      解法1 贪心
 *      解法2 dp(超时) dp[i][j]表示区间[i,j]的字符串最大的段的数量
 *           要使一个字符串为段式回文 需满足 左右两端点长度为k(1<=k<=len/2)的字符串相等
 *           当字符串长度=1时 本身就是段式回文串
 *           当字符串长度=2时 两个字符相等 则长度为2 否则整体作为一个字符串
 *           当字符串长度>2时 判断长度为k的字符串是否相等 状态转移方程为
 *           dp[i][j] = dp[i+k][j-k] + 2, 不相等则dp[i][j] = 1
 */
public class Test1147 {

    public int longestDecomposition(String text) {
        int n = text.length();
        // volvo
        if (text.length() <= 1) return n;
        for (int i = 1;i <= n/2;i++) {
            if (text.substring(0, i).equals(text.substring(n - i))) {
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        return 1;
    }

    public int longestDecomposition1(String text) {
        int n = text.length();
        char[] chars = text.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i++) {
            dp[i][i] = 1;
        }
        for (int len = 2;len <= n;len++) {
            for (int i = 0;i <= n - len;i++) {
                int j = i + len - 1;
                if (len == 2) {
                    if (chars[i] == chars[j]) dp[i][j] = 2;
                    else dp[i][j] = 1;
                } else {
                    dp[i][j] = 1;
                    for (int k = 1;k <= len/2;k++) {
                        String str1 = text.substring(i, i + k);
                        String str2 = text.substring(i + len - k, j + 1);
                        if (str1.equals(str2)) {
                            dp[i][j] = Math.max(dp[i][j], dp[i+k][j-k] + 2);
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String str = "ghiabcdefhelloadamhelloabcdefghi";
        Test1147 test = new Test1147();
        int res = test.longestDecomposition1(str);
        System.out.println(res);
    }
}
