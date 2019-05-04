package lintcode;

/**
 * @author Legend
 * @data by on 19-5-4.
 * @description rang-sum-query-2d-immutable
 * idea:
 *      dp 用dp[i][j]表示[0,0]-[i,j]范围内所有数的和 求得所有和后就可以根据给出的坐标减去对应范围外的和即可
 *      得出选定矩阵数值的和 所以关键是构建怎么这一张表了, 方法有多种 我这里是先计算了每一排的前缀和,  这样计算
 *      时 只需要用当前位置的前缀和加上当前位置上方坐标范围内的和 即dp[i][j] = dp[i-1][j] + sum[i][j]
 */
public class Test665 {

    static class NumMatrix {

        int[][] sum, dp;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            this.sum = new int[m+1][n+1];
            this.dp = new int[m+1][n+1];
            for (int i = 1;i <= m;i++) {
                for (int j = 1;j <= n;j++) {
                    sum[i][j] = sum[i][j-1] + matrix[i-1][j-1];
                }
            }
            for (int i = 1;i <= m;i++) {
                for (int j = 1;j <= n;j++) {
                    dp[i][j] = dp[i-1][j] + sum[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int s1 = dp[row1][col1];
            return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + s1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},
                          {5,6,3,2,1},
                          {1,2,0,1,5},
                          {4,1,0,1,7},
                          {1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1,2,2,4));
    }

}
