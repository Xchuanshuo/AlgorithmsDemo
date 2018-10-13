package lintcode;

import java.awt.font.FontRenderContext;

/**
 * @author Legend
 * @data by on 18-10-13.
 * @description smallest-path
 */
public class Test1612 {

    public int smallestPath(int[][] matrix) {
        // Write your code here
        int m = matrix.length, n = matrix[0].length;
        for (int i=1;i<m;i++) {
            for (int j=0;j<n;j++) {
                int cur = matrix[i-1][j];
                if (j>0) {
                    cur = Math.min(cur, matrix[i-1][j-1]);
                }
                if (j < n-1) {
                    cur = Math.min(cur, matrix[i-1][j+1]);
                }
                matrix[i][j] += cur;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {
            min = Math.min(min, matrix[m-1][i]);
        }
        return min;
    }
}
