package leetcode;

/**
 * @author Legend
 * @data by on 21-5-22.
 * @description https://leetcode-cn.com/problems/count-submatrices-with-all-ones/
 * idea:
 *      统计以当前节点为右下角的符合的矩形区域内1的个数, 即是以当前节点为右下角的子矩形个数
 */
public class Test1504 {

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][][] dp = new int[m+1][n+1][2];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (mat[i-1][j-1] == 0) continue;
                dp[i][j][0] = dp[i][j-1][0] + 1;
                dp[i][j][1] = dp[i-1][j][1] + 1;
            }
        }
        int res = 0;
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                int w = dp[i][j][0], h = dp[i][j][1];
                if (w == 0) continue;
                int t = 0, min = w;
                for (int r = 1;r < h;r++) {
                    if (dp[i-r][j][0] == 1) break;
                    min = Math.min(dp[i-r][j][0], min);
                    t += min - 1;
                }
                res +=  w + h-1 + t;
            }
        }
        return res;
    }
}
