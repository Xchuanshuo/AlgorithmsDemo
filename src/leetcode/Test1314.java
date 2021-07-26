package leetcode;

/**
 * @author Legend
 * @data by on 21-5-18.
 * @description https://leetcode-cn.com/problems/matrix-block-sum/
 */
public class Test1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m+1][n+1];
        for (int i = 1;i <= m;i++) {
            for (int j = 1;j <= n;j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                int x1 = Math.max(0, i-k), x2 = Math.min(m-1, i+k);
                int y1 = Math.max(0, j-k), y2 = Math.min(n-1,j+k);
                res[i][j] = sum[x2+1][y2+1] - sum[x1][y2+1]
                        - sum[x2+1][y1] + sum[x1][y1];
            }
        }
        return res;
    }
}
