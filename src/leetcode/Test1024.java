package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-5-16.
 * @description https://leetcode-cn.com/problems/video-stitching/
 */
public class Test1024 {

    public int videoStitching(int[][] clips, int t) {
        int INF =  (int)1e9;
        int[] dp = new int[t + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1;i <= t;i++) {
            for (int[] clip : clips) {
                if (clip[1] >= i && clip[0] <= i) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[t] == INF ? -1 : dp[t];
    }
}
