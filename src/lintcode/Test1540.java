package lintcode;

/**
 * @author Legend
 * @data by on 18-10-2.
 * @description can-convert
 * idea:
 *      可以用dp 但是时间复杂度为O(m*n) 空间复杂度为O(m*n) 而使用
 *      双指针的方式只需要O(m) 或 O(n)的时间 O(1)的空间
 */
public class Test1540 {

    public boolean canConvert(String s, String t) {
        // Write your code here
        if (s==null || t==null || s.length()<t.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i<s.length() && j<t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == t.length();
    }

    public boolean canConvert1(String s, String t) {
        if (s==null || t==null || s.length()<t.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        for (int i=0;i<=s.length();i++) {
            dp[i][0] = true;
        }
        for (int i=1;i<=s.length();i++) {
            for (int j=1;j<=t.length();j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
