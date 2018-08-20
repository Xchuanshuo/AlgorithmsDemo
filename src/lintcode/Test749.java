package lintcode;

/**
 * @author Legend
 * @data by on 18-8-20.
 * @description johns-backyard-garden
 * idea:
 *      dp 与背包问题1一样...
 */
public class Test749 {

    public String isBuild(int x) {
        // write you code here
        int[] dms = {3, 7};
        int[] dp = new int[x+1];
        for (int i=0;i<dms.length;i++) {
            for (int j=dms[i];j<=x;j++) {
                dp[j] = Math.max(dp[j], dp[j-dms[i]]+dms[i]);
                if (dp[j]==x) return "YES";
            }
        }
        return "NO";
    }
}
