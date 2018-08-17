package lintcode;

import tree.Set;

import java.util.HashSet;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description unique-paths-iii
 * idea:
 *      dp问题 由于这里要存路径和 所以用HashSet来去重
 *      dp[i][j] 表示位置i,j的不同路径的和
 *      当前位置的路径等于上边和左边路径的和
 *      即 dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class Test679 {

    public int uniqueWeightedPaths(int[][] grid) {
        // write your codes here
        int m = grid.length, n = grid[0].length;
        if (m==0 || n==0) return 0;
        HashSet<Integer>[][] dp = new HashSet[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                dp[i][j] = new HashSet<>();
                if (i==0 && j==0) dp[i][j].add(grid[0][0]);
                if (i != 0) {
                    for (int up: dp[i-1][j]) {
                        dp[i][j].add(up+grid[i][j]);
                    }
                }
                if (j != 0) {
                    for (int left: dp[i][j-1]) {
                        dp[i][j].add(left+grid[i][j]);
                    }
                }
            }
        }
        int result = 0;
        for (int i: dp[m-1][n-1]) result += i;
        return result;
    }
}
