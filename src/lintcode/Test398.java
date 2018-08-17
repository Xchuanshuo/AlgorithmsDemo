package lintcode;

/**
 * @author Legend
 * @data by on 18-8-17.
 * @description longest-continuous-increasing-subsequence-ii
 * idea:
 *      记忆化搜索+dfs 每次遍历到一个点都需要计算当前最大的连续增长子序列
 *      长度为多少 计算的方式就是遍历个方向的值
 */
public class Test398 {

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        if (matrix==null || matrix.length==0) return 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                result = Math.max(result, dfs(memo, i, j, matrix));
            }
        }
        return result;
    }

    private int dfs(int[][] memo, int i, int j, int[][] matrix) {
        if (memo[i][j] != 0) return memo[i][j];
        int cur = 1;
        for (int k=0;k<4;k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if (x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]>matrix[i][j]) {
                cur = Math.max(cur, dfs(memo, x, y, matrix)+1);
            }
        }
        memo[i][j] = cur;
        return memo[i][j];
    }
}
