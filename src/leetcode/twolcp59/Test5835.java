package leetcode.twolcp59;

/**
 * @author Legend
 * @data by on 21-8-21.
 * @description https://leetcode-cn.com/contest/biweekly-contest-59/problems/maximum-matrix-sum/
 */
public class Test5835 {

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0, min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (matrix[i][j] <= 0) {
                    cnt++;
                }
                min = Math.min(min, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if (cnt%2 == 0) return sum;
        return sum - 2*Math.abs(min);
    }
}
