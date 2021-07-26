package leetcode;

import java.util.Arrays;

/**
 * @author Legend
 * @data by on 21-4-19.
 * @description https://leetcode-cn.com/problems/cherry-pickup/
 * idea:
 *      一个人从左上到右下,再从右下到左上 => 求一个人从左上角->右下角的两条路径
 *      dp[r1][c1][r2][c2]表示从(r1,c1),(r2,c2)出发能获取的最大值
 *      因为只能向右或向下走一步 所以任意情况下 满足 r1+c1=c1+c2
 *      于是可以优化成三维数组 dp[r1][c1][c2] 其中r2=r1+c1-c2
 *      当两个位置是正常可通行路径时 且c1 != c2时 两个点肯定不为
 *      同一个点 需要+上两个位置的收益, 到达终点时 直接返回终点的收益即可
 */
public class Test741 {

    int n = 0;
    int[][][] mem;
    int[][] grid;
    public int cherryPickup(int[][] grid) {
        this.n= grid.length;
        this.mem = new int[n][n][n];
        this.grid = grid;
        for (int[][] me : mem) {
            for (int[] m : me) Arrays.fill(m, Integer.MIN_VALUE);
        }
        return Math.max(0, dp(0, 0, 0));
    }

    private int dp(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (r1 == n || c1 == n || r2 == n || c2 == n
                || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -99999;
        } else if (r2 == n-1 && c2 == n-1) {
            return grid[r1][c1];
        } else if (mem[r1][c1][c2] != Integer.MIN_VALUE) {
            return mem[r1][c1][c2];
        } else {
            int val = grid[r1][c1];
            if (c1 != c2) val += grid[r2][c2];
            val += Math.max(Math.max(dp(r1 + 1, c1, c2), dp(r1, c1 + 1, c2 + 1)),
                    Math.max(dp(r1 + 1, c1, c2 + 1), dp(r1, c1 + 1, c2)));
            mem[r1][c1][c2] = val;
            return val;
        }
    }
}
