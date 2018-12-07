package lintcode;

/**
 * @author Legend
 * @data by on 18-12-5.
 * @description range-sum-query-2d-mutable
 * idea:
 *      Binary Indexed Tree
 */
public class Test817 {

    class NumMatrix {

        private int[][] bit, arr;
        private int m, n;

        public NumMatrix(int[][] matrix) {
            this.m = matrix.length;
            this.n = matrix[0].length;
            this.arr = new int[m][n];
            this.bit = new int[m+1][n+1];
            for (int i=0;i<m;i++) {
                for (int j=0;j<n;j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int delta = val - arr[row][col];
            arr[row][col] = val;
            for (int i=row+1;i<=m;i+=lowbit(i)) {
                for (int j=col+1;j<=n;j+=lowbit(j)) {
                    bit[i][j] += delta;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum(row2, col2) - prefixSum(row2, col1-1) -
                    prefixSum(row1-1, col2) + prefixSum(row1-1, col1-1);
        }

        private int prefixSum(int row, int col) {
            int sum = 0;
            for (int i=row+1;i>0;i-=lowbit(i)) {
                for (int j=col+1;j>0;j-=lowbit(j)) {
                    sum += bit[i][j];
                }
            }
            return sum;
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }

}
