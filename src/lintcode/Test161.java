package lintcode;

/**
 * @author Legend
 * @data by on 19-5-8.
 * @description rotate-image
 * idea:
 *      1.沿x轴翻转 2.转置
 * 1 2 3     7 8 9     7 4 9     7 4 1     7 4 1
 * 4 5 6 --> 4 5 6 --> 8 5 6 --> 8 5 6 --> 8 5 2
 * 7 8 9     1 2 3     1 2 3     9 2 3     9 6 3
 */
public class Test161 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        for (int i = 0;i < n/2;i++) {
            for (int j = 0;j < n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        for (int i = 0;i < n;i++) {
            for (int j = i;j < n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
