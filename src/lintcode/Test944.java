package lintcode;

/**
 * @author Legend
 * @data by on 19-5-8.
 * @description maximum-submatrix
 * idea:
 *      这题的解法是很好的思想 1.纵向压缩 -> 选择左右两个边界 把边界里面的矩阵由二维压缩成一维
 *                         2. 横向压缩 -> 一维数组求最大子数组和
 *     这样算出来的值实际上就是由上、下、左、右边界确定出的矩阵里面元素的和, 每次比较求取最大值即可
 */
public class Test944 {

    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int max = Integer.MIN_VALUE;
        for (int l = 0;l < n;l++) {
            int[] column = new int[n];
            for (int r = l;r < n;r++) {
                for (int i = 0;i < n;i++) {
                    column[i] += matrix[i][r];
                }
                max = Math.max(max, getSubArrayMaxSum(column));
            }
        }
        return max;
    }

    private int getSubArrayMaxSum(int[] arr) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0;i < arr.length;i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}
