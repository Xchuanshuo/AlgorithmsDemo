package leetcode;

/**
 * @author Legend
 * @data by on 21-6-6.
 * @description https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class Test474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String w : strs) {
            int z = 0, f = 0;
            for (char c : w.toCharArray()) {
                if (c == '0') z++;
                else f++;
            }
            for (int i =m;i >= z;i--) {
                for (int j = n;j >= f;j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-z][j-f] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
