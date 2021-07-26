package leetcode;

/**
 * @author Legend
 * @data by on 21-4-12.
 * @description 1139. 最大的以 1 为边界的正方形
 * idea:
 *      统计以当前点结尾的左边与上边连续1的个数
 *      dp[i][j][0]表示第i行j列的点结尾的从上边开始的连续1的数量
 *      dp[i][j][1]表示第i行j列的点结尾的从左边开始的连续1的数量
 *      要找寻最大的以1为边界的正方形, 则根据上边和左边的连续1的数量,
 *      取较小的作为正方形的边 确定下右两条边后 则继续看接左上两条边是否满足情况
 *      不满足则将最大变成-1,重复上述步骤
 */
public class Test1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m+1][n+1][2];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                if (grid[i-1][j-1] == 1) {
                    dp[i][j][0] = dp[i-1][j][0] + 1;
                    dp[i][j][1] = dp[i][j-1][1] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                for (int e = Math.min(dp[i][j][0], dp[i][j][1]);e >= 1;e--) {
                    if (dp[i-e+1][j][1] >= e && dp[i][j-e+1][0] >= e) {
                        max = Math.max(max, e);
                        break;
                    }
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max * max;
    }
}
