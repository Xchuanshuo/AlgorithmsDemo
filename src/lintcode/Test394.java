package lintcode;

/**
 * @author Legend
 * @data by on 19-5-3.
 * @description coins-in-a-line
 */
public class Test394 {

    public boolean firstWillWin(int n) {
        // write your code here
        if (n==0) return false;
        if (n==1 || n==2) return true;
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        for (int i=3;i<=n;i++) {
            dp[i] = (dp[i-1]==false) || (dp[i-2]==false);
        }
        return dp[n];
    }
}
