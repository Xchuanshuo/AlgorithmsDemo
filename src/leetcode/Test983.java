package leetcode;

/**
 * @author Legend
 * @data by on 21-5-18.
 * @description https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class Test983 {

    public int mincostTickets(int[] days, int[] costs) {
        int max = 0;
        for (int d : days) max = Math.max(max, d);
        int[] dp = new int[max+1];
        int idx = 0;
        for (int i = 1;i <= max;i++) {
            if (i != days[idx]) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = Math.min(dp[i-1] + costs[0],
                        Math.min(dp[Math.max(i-7, 0)] + costs[1], dp[Math.max(i-30,0)] + costs[2]));
                idx++;
            }
        }
        return dp[max];
    }
}
