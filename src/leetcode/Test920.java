package leetcode;

/**
 * @author Legend
 * @data by on 21-6-25.
 * @description https://leetcode-cn.com/problems/number-of-music-playlists/
 * idea:
 *      dp[i][j]表示前n首歌 播放j首 且每首歌间隔k首播放的方案数
 *      要求dp[i][j], 有两种情况
 *      1.当前第j首播放的歌是新歌 方案数为 dp[i-1][j-1] * (n-(i-1))
 *      2.当前第j首播放的歌是老歌 方案数为 dp[i][j-1] * (i-k)
 *
 *      初始按条件: dp[0][0] = 1 结果: dp[n][l]
 */
public class Test920 {

    public int numMusicPlaylists(int n, int l, int k) {
        int M = (int)1e9 + 7;
        long[][] dp = new long[n+1][l+1];
        dp[0][0] = 1;
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= l;j++) {
                dp[i][j] += dp[i-1][j-1] * (n-i+1);
                if (i >= k) dp[i][j] += dp[i][j-1]*(i-k);
                dp[i][j] %= M;
            }
        }
        return (int)(dp[n][l]%M);
    }
}
