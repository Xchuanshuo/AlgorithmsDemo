package lintcode;

/**
 * @author Legend
 * @data by on 18-9-10.
 * @description maximum-vacation-days
 * idea:
 *      dp 用dp[city][week]表示第week周在城市city最多的休假天数 要求dp[city][week]就要
 *      用当前的days[city][week]+上周可获取最多度假天数(也就是遍历上周每一个城市 取最大值)
 *      当然前提条件是两个城市的航线是存在的 因为days[city][week]也包含了航线不存在的情况 所
 *      以在接下来这个情况被当作上一周计算时 就会过滤掉
 */
public class Test874 {

    public int maxVacationDays(int[][] flights, int[][] days) {
        // Write your code here
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[n][k];
        for (int i=0;i<n;i++) {
            dp[i][k-1] = days[i][k-1];
        }
        for (int week=k-2;week>=0;week--) {
            for (int city=0;city<n;city++) {
                dp[city][week] = days[city][week] + getMax(city, week+1, flights, dp);
            }
        }
        return getMax(0, 0, flights, dp);
    }

    public int getMax(int city, int week, int[][] flights, int[][] dp) {
        int max = dp[city][week];
        for (int i=0;i<flights[0].length;i++) {
            if (flights[city][i] == 1) {
                max = Math.max(max, dp[i][week]);
            }
        }
        return max;
    }
}
