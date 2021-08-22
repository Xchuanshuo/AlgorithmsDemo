package leetcode.twolcp59;


/**
 * @author Legend
 * @data by on 21-8-21.
 * @description https://leetcode-cn.com/contest/biweekly-contest-59/problems/number-of-ways-to-separate-numbers/
 */
public class Test5837 {

    public int numberOfCombinations(String num) {
        char[] chs = num.toCharArray();
        if (chs[0] == '0') return 0;
        int M = (int)1e9 + 7, n = chs.length;
        int[][] dp = new int[n][n];
        for (int i = 0;i < n;i++) dp[0][i] = 1;
        for (int i = 1;i < chs.length;i++) {
            int j = i, v1 = 0;
            int k = 0;
            while (j >= 0 && chs[j] != '0') {
                int c = chs[j] - '0';
                v1 += Math.pow(10, k) * c;
                int x = j-1, v2 = 0;
                int k2 = 0;
                while (x >= 0 && chs[x] != '0') {
                    int c2 = chs[x] - '0';
                    v2 += Math.pow(10, k2) * c2;
                    if (v2 > v1) break;
                    dp[i][j] = (dp[j][i] + dp[x][j-1])%M;
                    k2++;
                    x--;
                }
                k++;
                j--;
            }
        }
        int res = 0;
        for (int i = 0;i < n;i++) {
            res = (res + dp[i][n-1])%M;
        }
        return res;
    }
}
