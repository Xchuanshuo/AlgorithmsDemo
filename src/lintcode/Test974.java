package lintcode;

/**
 * @author Legend
 * @data by on 19-4-27.
 * @description 01-matrix
 * idea:
 *      可以用bfs 但更好的方式是使用dp 从左上丶右下各来一遍
 */
public class Test974 {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (matrix[i][j] == 0) continue;
                dp[i][j] = 1000000;
                if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
            }
        }
        print(dp);
        for (int i = m - 1;i >= 0;i--) {
            for (int j = n - 1;j >= 0;j--) {
                if (matrix[i][j] == 0) continue;
                if (i < m - 1) dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                if (j < n - 1) dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
            }
        }
        print(dp);
        return dp;
    }

    private void print(int[][] dp) {
        for (int i = 0;i < dp.length;i++) {
            for (int j = 0;j < dp[0].length;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,1,1},{1,0,1},{1,1,1},{1,1,1}};
        Test974 test974 = new Test974();
        test974.updateMatrix(matrix);
    }
}
