package leetcode;

/**
 * @author Legend
 * @data by on 21-4-27.
 * @description https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class Test647 {

    public int countSubstrings(String s) {
        int m = s.length();
        if (m == 0) return 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[m][m];
        for (int i = 0;i < m;i++) {
            dp[i][i] = true;
        }
        int res = 0;
        for (int len = 2;len <= m;len++) {
            for (int i = 0;i <= m - len;i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j] && (len == 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res + m;
    }

    public static void main(String[] args) {
        String str = "aaa";
        Test647 test = new Test647();
        int res = test.countSubstrings(str);
        System.out.println(res);
    }
}
