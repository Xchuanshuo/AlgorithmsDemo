package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-28.
 * @description https://leetcode-cn.com/problems/best-team-with-no-conflicts/
 * idea:
 *      依次根据年龄、分数从小到大排序 -> 最长上升子序列
 */
public class Test1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];
        for (int i = 0;i < n;i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        Arrays.sort(players, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int[] dp = new int[n];
        dp[0] = players[0][1];
        int max = dp[0];
        for (int i = 1;i < n;i++) {
            int cur = players[i][1];
            dp[i] = cur;
            for (int j = 0;j < i;j++) {
                if (cur >= players[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + cur);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
