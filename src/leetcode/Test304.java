package leetcode;

/**
 * @author Legend
 * @data by on 21-4-17.
 * @description https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * idea:
 *      https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/ru-he-qiu-er-wei-de-qian-zhui-he-yi-ji-y-6c21/
 */
public class Test304 {

    class NumMatrix {

        int[][] preSum;
        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            this.preSum = new int[m+1][n+1];
            for (int i = 1;i <= m;i++) {
                for (int j = 1;j <= n;j++) {
                    preSum[i][j] = preSum[i-1][j] + preSum[i][j-1]
                            - preSum[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1] - preSum[row1][col2+1]
                    - preSum[row2+1][col1] + preSum[row1][col1];
        }
    }

}
